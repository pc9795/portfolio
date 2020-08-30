package com.prashantchaubey.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("jwt")
@Getter
public class JWTProperties {
  private Auth auth = new Auth();
  private OAuth2 oAuth2 = new OAuth2();

  @Getter
  @Setter
  public static class Auth {
    private String tokenSecret;
    private long tokenExpirationMSec;
  }

  @Getter
  @Setter
  public static class OAuth2 {
    private List<String> authorizedRedirectUris = new ArrayList<>();
  }
}
