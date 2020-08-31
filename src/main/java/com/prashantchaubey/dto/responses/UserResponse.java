package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserResponse {
  private String name;

  private String email;

  private String imageUrl;
}
