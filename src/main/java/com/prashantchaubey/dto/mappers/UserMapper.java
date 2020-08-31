package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.SignupRequest;
import com.prashantchaubey.dto.responses.UserResponse;
import com.prashantchaubey.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
  User from(SignupRequest signupRequest);

  UserResponse toUserResponse(User user);
}
