package com.prashantchaubey.beans.oauth;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {
  GoogleOAuth2UserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getId() {
    return String.valueOf(attributes.get("sub"));
  }

  @Override
  public String getName() {
    return String.valueOf(attributes.get("name"));
  }

  @Override
  public String getEmail() {
    return String.valueOf(attributes.get("email"));
  }

  @Override
  public String getImageUrl() {
    return String.valueOf(attributes.get("picture"));
  }
}
