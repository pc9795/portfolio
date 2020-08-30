package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonDeserialize(builder = LoginRequest.LoginRequestBuilder.class)
@Builder(builderClassName = "LoginRequestBuilder")
@Value
public class LoginRequest {
  @NotBlank @Email private String email;
  @NotBlank private String password;

  // Required for Jackson to work with Lombok Immutable(@Value + @Builder)
  @JsonPOJOBuilder(withPrefix = "")
  static class LoginRequestBuilder {}
}
