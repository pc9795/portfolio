package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Value
public class BlogPostResponse {
  private String name;

  private String heading;

  private String description;

  private LocalDateTime createdAt;

  private Set<BlogTagResponse> blogTags;
}
