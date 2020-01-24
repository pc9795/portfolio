package com.prashantchaubey.utils;

/**
 * Created By: Prashant Chaubey
 * Created On: 18-05-2019 14:08
 * Purpose: TODO:
 **/
public final class Constants {
    private Constants() {
    }

    /**
     * API constraints
     */
    public static final class Constraints {
        private Constraints() {
        }

        public static final int MINIMUM_USERNAME_LENGTH = 5;
        public static final int MAXIMUM_USERNAME_LENGTH = 20;
        public static final int MINIMUM_PASSWORD_LENGTH = 8;
        public static final int MAXIMUM_FAILED_ATTEMPTS = 3;
    }


    public class Resource {
        private Resource() {
        }

        private static final String PREFIX = "/api/v1/";
        public static final String BLOG_ITEM = PREFIX + "blog_items";
    }

    /**
     * Error messages for error codes.
     */
    public static final class ErrorMsg {
        private ErrorMsg() {
        }

        public static final String USERNAME_NOT_FOUND = "User with the username:%s is not found";
        public static final String NOT_FOUND = "Resource not found:%s";
        public static final String UNAUTHORIZED = "Unauthorized";
        public static final String PASSWORDS_NOT_MATCH = "Passwords not match";
        public static final String FORBIDDEN_RESOURCE = "Forbidden Resource";
        public static final String INTERNAL_SERVER_ERROR = "Something bad happened";
        public static final String BAD_REQUEST = "Bad request";
        public static final String TAG_NOT_FOUND = "Tag doesn't exist : %s";
    }

    public static final String RESUME_FILE_NAME = "PrashantChaubey_resume.pdf";
    public static final int BLOG_DESCRIPTION_SIZE = 250;
}
