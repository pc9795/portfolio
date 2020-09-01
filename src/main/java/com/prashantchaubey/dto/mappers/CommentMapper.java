package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.CommentCreateRequest;
import com.prashantchaubey.dto.responses.CommentResponse;
import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.entities.Comment;
import com.prashantchaubey.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CommentMapper {

  @Mapping(
      source = "user",
      target = "commenterImageUrl",
      qualifiedByName = "userToCommenterImageUrl")
  @Mapping(source = "user", target = "commenterName", qualifiedByName = "userToCommenterName")
  public abstract CommentResponse toCommentResponse(Comment comment);

  public Comment from(CommentCreateRequest commentCreateRequest, User user, BlogPost blogPost) {
    return Comment.builder()
        .message(commentCreateRequest.getMessage())
        .user(user)
        .blogPost(blogPost)
        .build();
  }

  @Named("userToCommenterImageUrl")
  String userToCommenterImageUrl(User user) {
    return user.getImageUrl();
  }

  @Named("userToCommenterName")
  String userToCommenterName(User user) {
    return user.getName();
  }
}
