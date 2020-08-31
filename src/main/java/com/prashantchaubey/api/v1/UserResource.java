package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.UserCache;
import com.prashantchaubey.config.UserPrincipal;
import com.prashantchaubey.dto.mappers.UserMapper;
import com.prashantchaubey.dto.responses.UserResponse;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.exceptions.ResourceNotFoundException;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(Constants.Endpoint.USERS_V1)
public class UserResource {
  private UserCache userCache;
  private UserMapper userMapper;

  @Autowired
  public UserResource(UserCache userCache, UserMapper userMapper) {
    this.userCache = userCache;
    this.userMapper = userMapper;
  }

  @GetMapping("/me")
  public UserResponse getByEmail(@AuthenticationPrincipal UserPrincipal userPrincipal) {
    Optional<User> maybeUser = userCache.findByEmail(userPrincipal.getEmail());
    if (!maybeUser.isPresent()) {
      throw new ResourceNotFoundException(
          String.format("User with email [%s] not found", userPrincipal.getEmail()));
    }

    return userMapper.toUserResponse(maybeUser.get());
  }
}
