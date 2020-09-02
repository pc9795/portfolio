package com.prashantchaubey.dto.responses;

import com.prashantchaubey.entities.UserCommentReaction;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserCommentReactionResponse {
  private Long commentId;

  private UserCommentReaction.Type type;
}
