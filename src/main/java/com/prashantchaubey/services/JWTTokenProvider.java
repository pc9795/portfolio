package com.prashantchaubey.services;

import com.prashantchaubey.config.JWTProperties;
import com.prashantchaubey.config.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTTokenProvider {
  private JWTProperties jwtProperties;

  @Autowired
  public JWTTokenProvider(JWTProperties jwtProperties) {
    this.jwtProperties = jwtProperties;
  }

  public String createToken(Authentication authentication) {
    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
    Date expiryDate =
        new Date(System.currentTimeMillis() + jwtProperties.getAuth().getTokenExpirationMSec());

    return Jwts.builder()
        .setSubject(userPrincipal.getEmail())
        .setIssuedAt(new Date())
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, jwtProperties.getAuth().getTokenSecret())
        .compact();
  }

  public String getEmailFromToken(String token) {
    Claims claims = getClaimsFromToken(token);
    return claims.getSubject();
  }

  private Claims getClaimsFromToken(String token) {
    return Jwts.parser()
        .setSigningKey(jwtProperties.getAuth().getTokenSecret())
        .parseClaimsJws(token)
        .getBody();
  }

  public boolean validateToken(String token) {
    try {
      getClaimsFromToken(token);
      return true;
    } catch (Exception exc) {
      exc.printStackTrace();
    }
    return false;
  }
}
