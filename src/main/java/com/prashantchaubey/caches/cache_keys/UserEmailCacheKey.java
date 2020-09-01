package com.prashantchaubey.caches.cache_keys;

import com.prashantchaubey.caches.core.CacheKey;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserEmailCacheKey implements CacheKey {
  private String email;

  public UserEmailCacheKey(String email) {
    this.email = String.valueOf(email);
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getKeyStr() {
    return email;
  }
}
