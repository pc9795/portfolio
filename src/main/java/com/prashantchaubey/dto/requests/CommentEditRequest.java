package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonDeserialize(builder = CommentEditRequest.CommentEditRequestBuilder.class)
@Builder(builderClassName = "CommentEditRequestBuilder")
@Value
public class CommentEditRequest {
  @NotNull
  @Size(max = 5000)
  private String message;

  @JsonPOJOBuilder(withPrefix = "")
  static class CommentEditRequestBuilder {}
}
