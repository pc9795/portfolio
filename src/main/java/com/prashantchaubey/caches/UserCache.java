package com.prashantchaubey.caches;

import com.prashantchaubey.caches.core.CacheKey;
import com.prashantchaubey.caches.core.SimpleMapCache;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCache extends SimpleMapCache<User> {
    private UserRepository userRepository;

    @Autowired
    public UserCache(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User load(CacheKey key) {
        return null;
    }
}
