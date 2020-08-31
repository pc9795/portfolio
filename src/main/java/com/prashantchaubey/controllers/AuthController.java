package com.prashantchaubey.controllers;

import com.prashantchaubey.caches.UserCache;
import com.prashantchaubey.dto.mappers.UserMapper;
import com.prashantchaubey.dto.requests.LoginRequest;
import com.prashantchaubey.dto.requests.SignupRequest;
import com.prashantchaubey.dto.responses.AuthResponse;
import com.prashantchaubey.dto.responses.UserResponse;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.services.JWTTokenProvider;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.Endpoint.AUTH)
public class AuthController {
  private AuthenticationManager authenticationManager;
  private UserCache userCache;
  private PasswordEncoder passwordEncoder;
  private JWTTokenProvider JWTTokenProvider;
  private UserMapper userMapper;

  @Autowired
  public AuthController(
      AuthenticationManager authenticationManager,
      UserCache userCache,
      PasswordEncoder passwordEncoder,
      JWTTokenProvider JWTTokenProvider,
      UserMapper userMapper) {
    this.authenticationManager = authenticationManager;
    this.userCache = userCache;
    this.passwordEncoder = passwordEncoder;
    this.JWTTokenProvider = JWTTokenProvider;
    this.userMapper = userMapper;
  }

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  public AuthResponse login(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = JWTTokenProvider.createToken(authentication);
    return AuthResponse.builder().token(token).build();
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse register(@Valid @RequestBody SignupRequest signupRequest) {
    if (userCache.findByEmail(signupRequest.getEmail()).isPresent()) {
      throw new BadDataException(
          String.format("Email [%s] already in use", signupRequest.getEmail()));
    }

    SignupRequest passwordEncryptedSignupRequest =
        SignupRequest.builder()
            .name(signupRequest.getName())
            .email(signupRequest.getEmail())
            .password(passwordEncoder.encode(signupRequest.getPassword()))
            .build();
    User user = userMapper.from(passwordEncryptedSignupRequest);

    return userMapper.toUserResponse(userCache.save(user));
  }
}
