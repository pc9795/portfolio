package com.prashantchaubey.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


/**
 * Purpose: User of the application
 **/
@Entity
@Table(name = "users")
public class User implements UserDetails {

    public enum Role implements GrantedAuthority {

        REGULAR(Desc.REGULAR), USER_MANAGER(Desc.USER_MANAGER), ADMIN(Desc.ADMIN);

        private final String authority;

        Role(String authority) {
            this.authority = authority;
        }

        @Override
        public String getAuthority() {
            return authority;
        }

        //So that this enum can be used with places where a Constant string is required.
        public class Desc {
            public static final String REGULAR = "ROLE_REGULAR";
            public static final String USER_MANAGER = "ROLE_USER_MANAGER";
            public static final String ADMIN = "ROLE_ADMIN";
        }
    }

    @Id
    @GeneratedValue
    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String username;

    @Column(nullable = false)
    @Setter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Role role;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    @JsonIgnore
    private String activationKey;

    @Column(nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private Boolean activated;

    @Column(nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private Boolean locked;

    @Column(nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private Integer failedAttempts;

    @Column(nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private Boolean invited;

    //Spring Security methods
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return activated;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return username;
    }
}
