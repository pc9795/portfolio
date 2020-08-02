package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@ToString
@Entity
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Getter
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter
    private Role role;

    @Column(nullable = false, unique = true)
    @Getter
    private String activationKey;

    @Column(nullable = false)
    @Getter
    private Boolean activated;

    @Column(nullable = false)
    @Getter
    private Boolean locked;

    @Column(nullable = false)
    @Getter
    private Integer failedAttempts;

    @Column(nullable = false)
    @Getter
    private Boolean invited;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
