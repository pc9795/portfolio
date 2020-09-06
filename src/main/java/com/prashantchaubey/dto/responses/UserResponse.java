package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class UserResponse {
  @NonNull private Long id;

  @NonNull private String name;

  @NonNull private String email;

  private String imageUrl;
}
