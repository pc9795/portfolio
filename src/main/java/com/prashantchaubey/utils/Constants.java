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
    }


    public class Resource {
        private Resource() {
        }

        private static final String V1_PREFIX = "/api/v1/";
        public static final String BLOG_TAGS_V1 = V1_PREFIX + "blog-tags";
        public static final String BLOG_POSTS_V1 = V1_PREFIX + "blog-posts";
        public static final String PROJECTS_V1 = V1_PREFIX + "projects";
        public static final String LISTS_V1 = V1_PREFIX + "lists";
        public static final String CONTACTS_V1 = V1_PREFIX + "contacts";
    }

    public static final class ErrorMsg {
        private ErrorMsg() {
        }

        public static final String NOT_FOUND = "Resource not found:%s";
        public static final String UNAUTHORIZED = "Unauthorized";
        public static final String FORBIDDEN_RESOURCE = "Forbidden Resource";
        public static final String INTERNAL_SERVER_ERROR = "Something bad happened";
        public static final String BAD_REQUEST = "Bad request";
    }

    public static final class EntityGraphName {
        private EntityGraphName() {
        }

        public static final String BLOG_TAG_WITH_BLOG_POSTS_LOADED_WITH_BLOG_TAGS =
                "blog-tag-entity-graph-with-blog-posts-loaded-with-blog-tags";
        public static final String BLOG_POST_WITH_BLOG_TAGS = "blog-post-entity-graph-with-blog-tags";
    }

    public static final int BLOG_DESCRIPTION_SIZE = 250;
}
