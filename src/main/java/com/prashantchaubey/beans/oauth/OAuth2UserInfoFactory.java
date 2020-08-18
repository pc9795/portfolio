package com.prashantchaubey.beans.oauth;

import com.prashantchaubey.entities.User;

import java.util.Map;

public class OAuth2UserInfoFactory {

  public static OAuth2UserInfo getOAuthUser2Info(
      String registrationId, Map<String, Object> attributes) {
    User.AuthProvider authProvider = User.AuthProvider.fromValue(registrationId);
    switch (authProvider) {
      case GOOGLE:
        return new GoogleOAuth2UserInfo(attributes);
    }
    throw new RuntimeException(
        String.format("Login with [%s] is not supported yet", registrationId));
  }
}
