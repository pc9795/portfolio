package com.prashantchaubey.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "users")
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
        default:
          throw new RuntimeException(
              String.format("AuthProvider [%s] is not registered yet", value));
      }
    }
  }

  @Id @GeneratedValue private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  private String imageUrl;

  private boolean emailVerified;

  private String password;

  @Enumerated(EnumType.STRING)
  private AuthProvider provider;

  private String providerId;
}
