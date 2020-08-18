package com.prashantchaubey.config;

import com.prashantchaubey.services.JWTTokenProvider;
import com.prashantchaubey.services.PortfolioUserDetailsService;
import com.prashantchaubey.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {
  private JWTTokenProvider jwtTokenProvider;
  private PortfolioUserDetailsService portfolioUserDetailsService;

  @Autowired
  public JWTTokenAuthenticationFilter(
      JWTTokenProvider jwtTokenProvider, PortfolioUserDetailsService portfolioUserDetailsService) {
    this.jwtTokenProvider = jwtTokenProvider;
    this.portfolioUserDetailsService = portfolioUserDetailsService;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      doJWTAuthentication(request);
    } catch (Exception exc) {
      exc.printStackTrace();
    }
    filterChain.doFilter(request, response);
  }

  private void doJWTAuthentication(HttpServletRequest request) {
    String jwt = getJWTFromRequest(request);
    if (!Utils.isNotBlank(jwt) || !jwtTokenProvider.validateToken(jwt)) {
      return;
    }

    String email = jwtTokenProvider.getEmailFromToken(jwt);
    UserDetails userDetails = portfolioUserDetailsService.loadUserByUsername(email);
    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    authenticationToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
  }

  private String getJWTFromRequest(HttpServletRequest request) {
    return null;
  }
}
