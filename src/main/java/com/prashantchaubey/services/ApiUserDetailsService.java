package com.prashantchaubey.services;

import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Purpose: Implementation of UserDetailsService for this project. Provide interface to load a user from the database
 * by username.
 **/
@Service
public class ApiUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public ApiUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * It will load a user by his username.
     *
     * @param username username of the user
     * @return the loaded user
     * @throws UsernameNotFoundException if user with the given username dosen't exist.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
