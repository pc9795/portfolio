package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.UserCommentReactionResponse;
import com.prashantchaubey.entities.UserCommentReaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCommentReactionMapper {
  @Mapping(source = "id.commentId", target = "commentId")
  UserCommentReactionResponse toUserCommentReactionResponse(
      UserCommentReaction userCommentReaction);
}
