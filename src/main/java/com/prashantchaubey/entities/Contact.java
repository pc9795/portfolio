package com.prashantchaubey.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "contacts")
public class Contact implements Serializable {
  @Id @GeneratedValue private Long id;

  @NonNull private String name;

  private String contact;

  @NonNull private String email;

  private String purpose;

  @CreationTimestamp private LocalDateTime createdAt;
}
