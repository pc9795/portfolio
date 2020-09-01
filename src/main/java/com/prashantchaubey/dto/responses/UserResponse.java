package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserResponse {
  private Long id;

  private String name;

  private String email;

  private String imageUrl;
}
