package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BlogTagResponse {
  private String name;
}
