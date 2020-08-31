package com.prashantchaubey.caches;

import com.prashantchaubey.caches.core.CacheKey;
import com.prashantchaubey.caches.core.SimpleMapCache;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCache extends SimpleMapCache<User> {

  private final UserRepository userRepository;

  @Autowired
  public UserCache(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public User load(CacheKey key) {
    return null;
  }
}
