package com.prashantchaubey.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(
    name = "list_items",
    indexes = {
      @Index(columnList = "type", name = "list_items_type_idx"),
      @Index(columnList = "createdAt", name = "list_items_created_at_idx")
    })
public class ListItem implements Serializable {
  public enum Type {
    GAMING,
    TECHNICAL
  }

  @Id @GeneratedValue private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Type type;

  @CreationTimestamp private LocalDateTime createdAt;
}
