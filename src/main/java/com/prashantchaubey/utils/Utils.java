package com.prashantchaubey.utils;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prashantchaubey.entities.BlogItem;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By: Prashant Chaubey
 * Created On: 26-05-2019 16:47
 * Purpose: Utility methods for this project
 **/
public final class Utils {

    /**
     * Create a standard JSON message with given error code and message.
     *
     * @param errorCode    error code
     * @param errorMessage error message
     * @return json string formatted with given error code and message.
     */
    private static String createErrorJSON(int errorCode, String errorMessage) {
        ObjectNode errorNode = JsonNodeFactory.instance.objectNode();
        errorNode.put("code", errorCode);
        errorNode.put("message", errorMessage);
        ObjectNode root = JsonNodeFactory.instance.objectNode();
        root.set("error", errorNode);
        return root.toString();
    }

    /**
     * Utility method to create a JSON response for a particular error code and message.
     *
     * @param errorCode    error code
     * @param errorMessage error message
     * @param response     response object
     * @throws IOException if not able to update the response object
     */
    public static void createJSONErrorResponse(int errorCode, String errorMessage, HttpServletResponse response)
            throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(errorCode);
        response.getWriter().write(Utils.createErrorJSON(errorCode, errorMessage));
    }

    /**
     * Generate a description from the content.
     *
     * @param content content
     * @return description
     */
    private static String getDescriptionFromContent(String content) {
        if (content == null || content.length() == 0) {
            return "...";
        }
        if (content.length() > Constants.BLOG_DESCRIPTION_SIZE) {
            content = content.substring(0, Constants.BLOG_DESCRIPTION_SIZE);
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
            blogItem.setDescription(Utils.getDescriptionFromContent(blogItem.getContent()
            ));
        }
    }
}
