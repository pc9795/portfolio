package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Value
public class BlogPostWithContentResponse {
    private String name;

    private String heading;

    private String description;

    private LocalDateTime createdAt;

    private String content;

    private Set<BlogTagResponse> blogTags;
}
