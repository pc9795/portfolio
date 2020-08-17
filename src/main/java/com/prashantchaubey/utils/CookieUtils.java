package com.prashantchaubey.utils;

import org.springframework.util.SerializationUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public final class CookieUtils {
  private CookieUtils() {}

  public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
    Cookie[] cookies = request.getCookies();
    if (isNullOfEmpty(cookies)) {
      return Optional.empty();
    }
    return Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(name)).findFirst();
  }

  private static boolean isNullOfEmpty(Object[] objects) {
    return objects == null || objects.length == 0;
  }

  public static void addCookie(
      HttpServletResponse response, String name, String value, int maxAge) {
    Cookie cookie = new Cookie(name, value);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(maxAge);
    response.addCookie(cookie);
  }

  public static void deleteCookie(
      HttpServletRequest request, HttpServletResponse response, String name) {
    Optional<Cookie> maybeCookie = getCookie(request, name);
    if (!maybeCookie.isPresent()) {
      return;
    }
    addCookie(response, name, "", 0);
  }

  public static String serialize(Object object) {
    return Base64.getUrlEncoder().encodeToString(SerializationUtils.serialize(object));
  }

  public static <T> T deserialize(Cookie cookie, Class<T> cls) {
    return cls.cast(SerializationUtils.deserialize(Base64.getDecoder().decode(cookie.getValue())));
  }
}
