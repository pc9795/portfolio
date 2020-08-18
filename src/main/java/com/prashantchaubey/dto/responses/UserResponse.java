package com.prashantchaubey.dto.responses;

import com.prashantchaubey.entities.User;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserResponse {
  private String name;
  private String email;
  private String imageUrl;
  private boolean emailVerified;
  private User.AuthProvider authProvider;
  private String providerId;
}
