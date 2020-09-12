package com.prashantchaubey.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(
    name = "users",
    indexes = {@Index(columnList = "email", name = "users_email_idx")})
public class User {
  public enum AuthProvider {
    GOOGLE("google"),
    LOCAL("local");

    private String value;

    AuthProvider(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public static AuthProvider fromValue(String value) {
      switch (value) {
        case "google":
          return GOOGLE;
        case "local":
          return LOCAL;
        default:
          throw new RuntimeException(
              String.format("AuthProvider [%s] is not registered yet", value));
      }
    }
  }

  @Id @GeneratedValue private Long id;

  @NonNull
  @Column(nullable = false)
  private String name;

  @NonNull
  @Column(nullable = false)
  private String email;

  private String imageUrl;

  private boolean emailVerified;

  private String password;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  private AuthProvider provider = AuthProvider.LOCAL;

  private String providerId;

  @NonNull
  @ManyToMany
  @JoinTable(
      name = "user_permissions",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"),
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT),
      inverseForeignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Set<Permission> permissionSet;
}
