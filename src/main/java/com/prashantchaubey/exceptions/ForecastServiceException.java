package com.prashantchaubey.exceptions;

/**
 * Created By: Prashant Chaubey
 * Created On: 15-01-2020 18:04
 * Purpose: Error in `ForecastService`
 **/
public class ForecastServiceException extends Exception {
    public ForecastServiceException(String message) {
        super(message);
    }

    public ForecastServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
