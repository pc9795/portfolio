package com.prashantchaubey.entities;

import com.prashantchaubey.utils.Constants;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@NamedEntityGraph(
    name = Constants.EntityGraphName.COMMENT_WITH_USERS,
    attributeNodes = @NamedAttributeNode("user"))
@Entity
@Table(
    name = "comments",
    indexes = {
      @Index(columnList = "blog_post_id,createdAt", name = "comments_blog_post_id_created_at_idx")
    })
public class Comment {
  @Id @GeneratedValue private Long id;

  @Builder.Default private Integer upVotes = 0;

  @Builder.Default private Integer downVotes = 0;

  @NonNull
  @Lob
  @Type(type = "org.hibernate.type.TextType")
  @Column(nullable = false)
  private String message;

  @CreationTimestamp private LocalDateTime createdAt;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "user_id",
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private User user;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "blog_post_id",
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private BlogPost blogPost;
}
