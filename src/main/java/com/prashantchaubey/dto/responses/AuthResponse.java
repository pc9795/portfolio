package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AuthResponse {
  private String token;

  private String tokenType = "Bearer";
}
