package com.prashantchaubey.caches;

import com.prashantchaubey.caches.cache_keys.UserEmailCacheKey;
import com.prashantchaubey.caches.core.SimpleMapCache;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCache {

  private final UserRepository userRepository;
  private SimpleMapCache<UserEmailCacheKey, Optional<User>> userEmailCache;

  @Autowired
  public UserCache(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.userEmailCache =
        new SimpleMapCache<>() {
          @Override
          public Optional<User> load(UserEmailCacheKey cacheKey) {
            return userRepository.findByEmail(cacheKey.getEmail());
          }
        };
  }

  public Optional<User> findByEmail(String email) {
    return userEmailCache.get(UserEmailCacheKey.builder().email(email).build());
  }

  public User save(User user) {
    userEmailCache.delete(UserEmailCacheKey.builder().email(user.getEmail()).build());
    return userRepository.save(user);
  }

  public User getOne(Long id) {
    return userRepository.getOne(id);
  }
}
