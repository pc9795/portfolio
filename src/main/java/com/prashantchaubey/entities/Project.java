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
@Table(
    name = "projects",
    indexes = {@Index(columnList = "createdAt", name = "projects_created_at_idx")})
public class Project {

  @Id @GeneratedValue private Long id;

  @NonNull
  @Column(nullable = false, unique = true)
  private String name;

  @NonNull
  @Column(nullable = false)
  private String heading;

  @NonNull private String description;

  @CreationTimestamp private LocalDateTime createdAt;

  @NonNull private String createdBy;

  @NonNull private String link;
}
