package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class CommentResponse {
  private Long id;

  private Integer upVotes;

  private Integer downVotes;

  private String message;

  private String commenterImageUrl;

  private String commenterName;

  private LocalDateTime createdAt;
}
