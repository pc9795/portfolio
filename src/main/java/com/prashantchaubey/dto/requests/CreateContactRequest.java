package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@Value
@JsonDeserialize(builder = CreateContactRequest.CreateContactRequestBuilder.class)
public class CreateContactRequest {
    @NotNull
    private String name;

    @NotNull
    private String contact;

    @Email
    @NotNull
    private String email;

    private String purpose;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CreateContactRequestBuilder {

    }
}
