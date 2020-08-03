package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@Value
@JsonDeserialize(builder = ContactCreateRequest.CreateContactRequestBuilder.class)
public class ContactCreateRequest {
    @NotNull
    private String name;

    @NotNull
    private String contact;

    @Email
    @NotNull
    private String email;

    private String purpose;

    // Required for Jackson to work with Lombok Immutable(@Value + @Builder)
    @JsonPOJOBuilder(withPrefix = "")
    static class CreateContactRequestBuilder {

    }
}
