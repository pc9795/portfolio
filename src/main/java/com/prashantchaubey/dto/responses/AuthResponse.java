package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class AuthResponse {
  @NonNull private String token;

  private String tokenType = "Bearer";
}
