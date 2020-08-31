package com.prashantchaubey.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "blog_tags")
public class BlogTag {
  @Id @GeneratedValue private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @CreationTimestamp private LocalDateTime createdAt;

  private String createdBy;
}
