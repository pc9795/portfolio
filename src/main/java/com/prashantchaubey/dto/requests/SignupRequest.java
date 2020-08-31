package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.prashantchaubey.entities.User;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonDeserialize(builder = SignupRequest.SignupRequestBuilder.class)
@Builder(builderClassName = "SignupRequestBuilder")
@Value
public class SignupRequest {
  @NotBlank private String name;

  @NotBlank @Email private String email;

  @NotBlank private String password;

  private User.AuthProvider provider = User.AuthProvider.LOCAL;

  // Required for Jackson to work with Lombok Immutable(@Value + @Builder)
  @JsonPOJOBuilder(withPrefix = "")
  public static class SignupRequestBuilder {}
}
