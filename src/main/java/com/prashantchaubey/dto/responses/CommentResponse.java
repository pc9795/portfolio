package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class CommentResponse {
  @NonNull private Long id;

  @NonNull private Integer upVotes;

  @NonNull private Integer downVotes;

  @NonNull private String message;

  private String commenterImageUrl;

  @NonNull private String commenterName;

  @NonNull private LocalDateTime createdAt;
}
