package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonDeserialize(builder = ContactCreateRequest.ContactCreateRequestBuilder.class)
@Builder(builderClassName = "ContactCreateRequestBuilder")
@Value
public class ContactCreateRequest {
  @NotNull @NotEmpty private String name;

  @NotNull @NotEmpty private String contact;

  @Email @NotNull @NotEmpty private String email;

  private String purpose;

  // Required for Jackson to work with Lombok Immutable(@Value + @Builder)
  @JsonPOJOBuilder(withPrefix = "")
  static class ContactCreateRequestBuilder {}
}
