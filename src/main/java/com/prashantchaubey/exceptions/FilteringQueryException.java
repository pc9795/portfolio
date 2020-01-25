package com.prashantchaubey.exceptions;

/**
 * Created By: Prashant Chaubey
 * Created On: 15-01-2020 14:59
 * Purpose: If the search string to filter a list of resources is not correct.
 **/
public class FilteringQueryException extends Exception {
    public FilteringQueryException(String message) {
        super(message);
    }
}
