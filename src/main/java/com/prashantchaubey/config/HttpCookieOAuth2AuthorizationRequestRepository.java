package com.prashantchaubey.config;

import com.prashantchaubey.utils.CookieUtils;
import com.prashantchaubey.utils.Utils;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * By default, Spring OAuth2 uses `HttpSessionOAuth2AuthorizationRequestRepository` to save the
 * authorization request. But, since our service is stateless, we can't save it it the session.
 * We'll save the request in a Base64 enoded cookie instead.
 */
@Component
public class HttpCookieOAuth2AuthorizationRequestRepository
    implements AuthorizationRequestRepository {
  static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
  private static final String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_ANME = "oauth2_auth_request";
  private static final int COOKIES_EXPIRY_SECS = 180;

  @Override
  public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
    return CookieUtils.getCookie(request, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_ANME)
        .map(cookie -> CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class))
        .orElse(null);
  }

  @Override
  public void saveAuthorizationRequest(
      OAuth2AuthorizationRequest oAuth2AuthorizationRequest,
      HttpServletRequest request,
      HttpServletResponse response) {
    if (oAuth2AuthorizationRequest == null) {
      CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_ANME);
      CookieUtils.deleteCookie(request, response, REDIRECT_URI_PARAM_COOKIE_NAME);
      return;
    }

    CookieUtils.addCookie(
        response,
        OAUTH2_AUTHORIZATION_REQUEST_COOKIE_ANME,
        CookieUtils.serialize(oAuth2AuthorizationRequest),
        COOKIES_EXPIRY_SECS);
    String redirectUriAfterLogin = request.getParameter(REDIRECT_URI_PARAM_COOKIE_NAME);
    if (Utils.isNotBlank(redirectUriAfterLogin)) {
      CookieUtils.addCookie(
          response, REDIRECT_URI_PARAM_COOKIE_NAME, redirectUriAfterLogin, COOKIES_EXPIRY_SECS);
    }
  }

  @Override
  public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
    throw new RuntimeException("Not implemented");
  }

  void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
    CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_ANME);
    CookieUtils.deleteCookie(request, response, REDIRECT_URI_PARAM_COOKIE_NAME);
  }
}
