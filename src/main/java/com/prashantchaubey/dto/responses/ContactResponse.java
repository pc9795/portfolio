package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class ContactResponse {

  @NonNull private String name;

  private String contact;

  @NonNull private String email;

  private String purpose;
}
