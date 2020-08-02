package com.prashantchaubey.dto;

import static com.prashantchaubey.utils.Constants.*;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Builder
public class LoginRequest {
    @NotNull
    @Length(min = Constraints.MINIMUM_USERNAME_LENGTH, max = Constraints.MAXIMUM_USERNAME_LENGTH)
    @Getter
    private String username;

    @NotNull
    @Length(min = Constraints.MINIMUM_PASSWORD_LENGTH)
    @Getter
    private String password;
}
