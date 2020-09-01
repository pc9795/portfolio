package com.prashantchaubey.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "permissions")
public class Permission {

  public enum Type {}

  @Id @GeneratedValue private Long id;

  @Enumerated(EnumType.STRING)
  private Type type;
}
