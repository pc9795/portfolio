package com.prashantchaubey.utils;

/**
 * Created By: Prashant Chaubey
 * Created On: 18-05-2019 14:08
 * Purpose: TODO:
 **/
public final class Constants {
    private Constants() {
    }

    public class Resource {
        private Resource() {
        }

        private static final String PREFIX = "/api/v1/";
        public static final String BLOG_ITEM = PREFIX + "blog_items";
    }

    public static final String RESUME_FILE_NAME = "PrashantChaubey_resume.pdf";
    public static final int BLOG_DESCRIPTION_SIZE = 250;
}
