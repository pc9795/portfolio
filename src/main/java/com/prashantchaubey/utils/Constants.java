package com.prashantchaubey.utils;

public final class Constants {
    private Constants() {
    }

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

        private static final String V1_PREFIX = "/api/v1/";
        public static final String BLOG_POSTS_V1 = V1_PREFIX + "blog-posts";
        public static final String PROJECTS_V1 = V1_PREFIX + "projects";
        public static final String LISTS_V1 = V1_PREFIX + "lists";
        public static final String CONTACTS_V1 = V1_PREFIX + "contacts";
    }

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

    public static final int BLOG_DESCRIPTION_SIZE = 250;
}
