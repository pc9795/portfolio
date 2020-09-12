package com.prashantchaubey.services;

import com.prashantchaubey.caches.UserCache;
import com.prashantchaubey.config.UserPrincipal;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.exceptions.BadDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PortfolioUserDetailsService implements UserDetailsService {
  private UserCache userCache;

  @Autowired
  public PortfolioUserDetailsService(UserCache userCache) {
    this.userCache = userCache;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user =
        userCache
            .findByEmail(email)
            .orElseThrow(
                () -> new BadDataException(String.format("User not found with email [%s]", email)));
    return UserPrincipal.create(user);
  }
}
