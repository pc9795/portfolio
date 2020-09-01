package com.prashantchaubey.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(
    name = "user_comment_reactions",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "comment_id", "type"}))
public class UserCommentReaction {
  public enum Type {
    UP_VOTE,
    DOWN_VOTE
  }

  @EmbeddedId private UserCommentReactionId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "user_id",
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  @MapsId("userId")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "comment_id",
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  @MapsId("commentId")
  private Comment comment;

  @Enumerated(EnumType.STRING)
  private Type type;
}
