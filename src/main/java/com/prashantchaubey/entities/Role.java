package com.prashantchaubey.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN(Desc.ADMIN);

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public class Desc {
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
