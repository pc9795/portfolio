package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ProjectResponse {
  @NonNull private String name;

  @NonNull private String heading;

  @NonNull private String description;

  @NonNull private LocalDateTime createdAt;

  @NonNull private String link;
}
