package com.prashantchaubey.exceptions;

/**
 * Created By: Prashant Chaubey
 * Created On: 26-10-2019 12:52
 * Purpose: Exception if user already exists in database.
 **/
public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
