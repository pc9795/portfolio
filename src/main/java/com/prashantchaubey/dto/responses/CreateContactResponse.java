package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateContactResponse {
    private String name;

    private String contact;

    private String email;

    private String purpose;
}
