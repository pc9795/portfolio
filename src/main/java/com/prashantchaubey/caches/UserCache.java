package com.prashantchaubey.caches;

import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCache {
    private UserRepository userRepository;

    @Autowired
    public UserCache(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
