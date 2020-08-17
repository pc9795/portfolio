package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.SignupRequest;
import com.prashantchaubey.dto.responses.UserResponse;
import com.prashantchaubey.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User to(SignupRequest signupRequest);

  UserResponse from(User user);
}
