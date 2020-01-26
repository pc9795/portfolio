package com.prashantchaubey.controllers;

import com.prashantchaubey.dto.auth.LoginRequest;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.jpa.UserRepository;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Purpose: Controller for authentication
 */
@RestController
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Create a session of a user with given credentials.
     *
     * @param request      request object
     * @param loginRequest user credentials
     * @return the logged in user
     * @throws ServletException if servlet API is not able to login user with the given credentials.
     */
    @PostMapping("/login")
    public User login(HttpServletRequest request, @Valid @RequestBody LoginRequest loginRequest)
            throws ServletException {
        //Check user exists in the database
        User user = userRepository.findUserByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new BadCredentialsException(String.format(Constants.ErrorMsg.USERNAME_NOT_FOUND, loginRequest.getUsername()));
        }
        //Check passwords
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            //Recording failed attempts
            user.setFailedAttempts(user.getFailedAttempts() + 1);
            //Locking if failed attempts increase a given value
            user.setLocked(user.getFailedAttempts() >= Constants.Constraints.MAXIMUM_FAILED_ATTEMPTS);
            //Save
            userRepository.save(user);
            throw new BadCredentialsException(Constants.ErrorMsg.PASSWORDS_NOT_MATCH);
        }
        //Create a session with the help of ServletAPI.
        request.login(loginRequest.getUsername(), loginRequest.getPassword());
        return user;
    }
}
