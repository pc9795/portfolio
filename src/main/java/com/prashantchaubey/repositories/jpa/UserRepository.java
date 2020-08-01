package com.prashantchaubey.repositories.jpa;

import com.prashantchaubey.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Purpose: Repository for User entity
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by given username
     *
     * @param username username of the user
     * @return user object
     */
    User findUserByUsername(String username);
}