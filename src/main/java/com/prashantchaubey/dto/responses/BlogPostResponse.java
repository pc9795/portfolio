package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Value
public class BlogPostResponse {
  @NonNull private Long id;

  @NonNull private String name;

  @NonNull private String heading;

  private String description;

  @NonNull private LocalDateTime createdAt;

  @NonNull private Set<BlogTagResponse> blogTags;
}
