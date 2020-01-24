package com.prashantchaubey.dto.auth;

import com.prashantchaubey.utils.Constants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Purpose: Information required during login
 **/
public class LoginRequest {
    @NotNull
    @Length(min = Constants.Constraints.MINIMUM_USERNAME_LENGTH, max = Constants.Constraints.MAXIMUM_USERNAME_LENGTH)
    @Getter
    @Setter
    private String username;
    @NotNull
    @Length(min = Constants.Constraints.MINIMUM_PASSWORD_LENGTH)
    @Getter
    @Setter
    private String password;
}
