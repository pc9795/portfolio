package com.prashantchaubey.entities;

import com.prashantchaubey.utils.Constants;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@NamedEntityGraph(
    name = Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS,
    attributeNodes = @NamedAttributeNode("blogTags"))
@Entity
@Table(
    name = "blog_posts",
    indexes = {@Index(columnList = "createdAt", name = "blog_posts_created_at_idx")})
public class BlogPost {
  @Id @GeneratedValue private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private String heading;

  private String description;

  @CreationTimestamp private LocalDateTime createdAt;

  private String createdBy;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  @Column(nullable = false)
  private String content;

  @ManyToMany
  @JoinTable(
      name = "blog_posts_to_blog_tags",
      joinColumns = @JoinColumn(name = "blog_post_id"),
      inverseJoinColumns = @JoinColumn(name = "blog_tag_id"),
      foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
      inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
  private Set<BlogTag> blogTags;
}
