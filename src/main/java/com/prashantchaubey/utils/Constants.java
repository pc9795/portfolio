package com.prashantchaubey.utils;

public final class Constants {
  private Constants() {}

  public class Endpoint {
    private Endpoint() {}

    private static final String BASE = "/api";
    public static final String AUTH = BASE + "/auth";
    private static final String V1_PREFIX = BASE + "/v1";
    public static final String BLOG_TAGS_V1 = V1_PREFIX + "/blog-tags";
    public static final String BLOG_POSTS_V1 = V1_PREFIX + "/blog-posts";
    public static final String PROJECTS_V1 = V1_PREFIX + "/projects";
    public static final String LISTS_V1 = V1_PREFIX + "/lists";
    public static final String CONTACTS_V1 = V1_PREFIX + "/contacts";
  }

  public static final class ErrorMsg {
    private ErrorMsg() {}

    public static final String NOT_FOUND = "Resource not found:%s";
    public static final String INTERNAL_SERVER_ERROR = "Something bad happened";
    public static final String BAD_REQUEST = "Bad request";
  }

  public static final class EntityGraphName {
    private EntityGraphName() {}

    public static final String BLOG_POST_WITH_BLOG_TAGS = "blog-post-entity-graph-with-blog-tags";
  }
}
