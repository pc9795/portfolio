package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonDeserialize(builder = CommentCreateRequest.CommentCreateRequestBuilder.class)
@Builder(builderClassName = "CommentCreateRequestBuilder")
@Value
public class CommentCreateRequest {
  @NotNull
  @Size(min = 15, max = 600)
  private String message;

  @NotNull private Long blogPostId;

  @JsonPOJOBuilder(withPrefix = "")
  static class CommentCreateRequestBuilder {}
}
