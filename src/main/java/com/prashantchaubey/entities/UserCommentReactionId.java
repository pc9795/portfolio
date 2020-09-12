package com.prashantchaubey.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Embeddable
public class UserCommentReactionId implements Serializable {
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "comment_id")
  private Long commentId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserCommentReactionId that = (UserCommentReactionId) o;
    return com.google.common.base.Objects.equal(userId, that.userId) &&
            com.google.common.base.Objects.equal(commentId, that.commentId);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(userId, commentId);
  }
}
