package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.config.UserPrincipal;
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
      source = "comment.user",
      target = "commenterImageUrl",
      qualifiedByName = "userToCommenterImageUrl")
  @Mapping(
      source = "comment.user",
      target = "commenterName",
      qualifiedByName = "userToCommenterName")
  @Mapping(
      target = "createdByRequester",
      expression = "java(requester!=null && requester.getId()==comment.getUser().getId())")
  @Mapping(target = "id", source = "comment.id")
  public abstract CommentResponse toCommentResponse(Comment comment, UserPrincipal requester);

  @Mapping(
      source = "comment.user",
      target = "commenterImageUrl",
      qualifiedByName = "userToCommenterImageUrl")
  @Mapping(
      source = "comment.user",
      target = "commenterName",
      qualifiedByName = "userToCommenterName")
  @Mapping(source = "updatedMessage", target = "message")
  @Mapping(
      target = "createdByRequester",
      expression = "java(requester!=null && requester.getId()==comment.getUser().getId())")
  @Mapping(target = "id", source = "comment.id")
  public abstract CommentResponse toCommentResponse(
      Comment comment, String updatedMessage, UserPrincipal requester);

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
