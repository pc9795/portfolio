package com.prashantchaubey.dto.responses;

import com.prashantchaubey.entities.UserCommentReaction;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class UserCommentReactionResponse {
  @NonNull
  private Long commentId;

  @NonNull
  private UserCommentReaction.Type type;
}
