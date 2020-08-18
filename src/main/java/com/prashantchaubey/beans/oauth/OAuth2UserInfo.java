package com.prashantchaubey.beans.oauth;

import java.util.HashMap;
import java.util.Map;

public abstract class OAuth2UserInfo {
  Map<String, Object> attributes;

  OAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = new HashMap<>(attributes);
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public abstract String getId();

  public abstract String getName();

  public abstract String getEmail();

  public abstract String getImageUrl();
}
