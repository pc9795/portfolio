package com.prashantchaubey.services;

import com.prashantchaubey.config.UserPrincipal;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PortfolioUserDetailsService implements UserDetailsService {
  private UserRepository userRepository;

  @Autowired
  public PortfolioUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(
                () -> new BadDataException(String.format("User not found with email [%s]", email)));
    return UserPrincipal.create(user);
  }
}
