package com.prashantchaubey.config;

import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.services.JWTTokenProvider;
import com.prashantchaubey.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static com.prashantchaubey.config.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private JWTTokenProvider JWTTokenProvider;
  private JWTProperties jwtProperties;
  private HttpCookieOAuth2AuthorizationRequestRepository
      httpCookieOAuth2AuthorizationRequestRepository;

  @Autowired
  public OAuth2AuthenticationSuccessHandler(
          JWTTokenProvider JWTTokenProvider,
          JWTProperties jwtProperties,
          HttpCookieOAuth2AuthorizationRequestRepository
          httpCookieOAuth2AuthorizationRequestRepository) {
    this.JWTTokenProvider = JWTTokenProvider;
    this.jwtProperties = jwtProperties;
    this.httpCookieOAuth2AuthorizationRequestRepository =
        httpCookieOAuth2AuthorizationRequestRepository;
  }

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    String targetUrl = determineTargetUrl(request, response, authentication);
    if (response.isCommitted()) {
      // Response is already committed no redirect
      return;
    }
    clearAuthenticationAttributes(request, response);
    getRedirectStrategy().sendRedirect(request, response, targetUrl);
  }

  @Override
  protected String determineTargetUrl(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    Optional<String> redirectUri =
        CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME).map(Cookie::getValue);
    if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
      throw new BadDataException(
          "Received unauthorized redirect uri and can't proceed with the authentication");
    }

    String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
    String token = JWTTokenProvider.createToken(authentication);

    return UriComponentsBuilder.fromUriString(targetUrl)
        .queryParam("token", token)
        .build()
        .toString();
  }

  private void clearAuthenticationAttributes(
      HttpServletRequest request, HttpServletResponse response) {
    super.clearAuthenticationAttributes(request);
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(
        request, response);
  }

  private boolean isAuthorizedRedirectUri(String uri) {
    URI uriObj = URI.create(uri);

    return jwtProperties.getOAuth2().getAuthorizedRedirectUris().stream()
        .anyMatch(
            authorizedRedirectUri -> {
              URI authorizedRedirectUriObj = URI.create(authorizedRedirectUri);
              // Not concerned with paths
              return (authorizedRedirectUriObj.getHost().equalsIgnoreCase(uriObj.getHost())
                  && authorizedRedirectUriObj.getPort() == uriObj.getPort());
            });
  }
}
