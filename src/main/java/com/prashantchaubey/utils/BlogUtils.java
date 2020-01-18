package com.prashantchaubey.utils;

import com.prashantchaubey.entities.BlogItem;

/**
 * Created By: Prashant Chaubey
 * Created On: 26-05-2019 16:47
 * Purpose: TODO:
 **/
public final class BlogUtils {
    public static String getDescriptionFromContent(String content, int descriptionSize) {
        if (content == null || content.length() == 0) {
            return "...";
        }
        if (content.length() > descriptionSize) {
            content = content.substring(0, descriptionSize);
        }
        char[] contentChars = content.toCharArray();
        int i = contentChars.length - 1;
        for (; i >= 0; i--) {
            if (contentChars[i] == 32) {
                break;
            }
        }
        if (i == -1) {
            return "...";
        }
        return new String(contentChars, 0, i) + "...";
    }

    public static void checkAndFillDescriptionIfNot(BlogItem blogItem) {
        if (blogItem.getDescription() == null || blogItem.getDescription().trim().isEmpty()) {
            blogItem.setDescription(BlogUtils.getDescriptionFromContent(blogItem.getContent(),
                    Constants.BLOG_DESCRIPTION_SIZE));
        }
    }
}
