package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class BlogTagResponse {
  @NonNull private String name;
}
