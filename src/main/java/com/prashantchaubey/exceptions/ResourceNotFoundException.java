package com.prashantchaubey.exceptions;

/**
 * Purpose: Exception when a requested resource is not found.
 **/
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
