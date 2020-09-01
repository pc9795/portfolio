package com.prashantchaubey.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonDeserialize(builder = CommentCreateRequest.CommentCreateRequestBuilder.class)
@Builder(builderClassName = "CommentCreateRequestBuilder")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class CommentCreateRequest {
  @NotNull
  @Size(max = 5000)
  private String message;

  @NotNull private Long blogPostId;

  @JsonPOJOBuilder(withPrefix = "")
  static class CommentCreateRequestBuilder {}
}
