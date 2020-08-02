package com.prashantchaubey.utils;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class Utils {

    public static String createErrorJSON(int errorCode, String errorMessage) {
        ObjectNode errorNode = JsonNodeFactory.instance.objectNode();
        errorNode.put("code", errorCode);
        errorNode.put("message", errorMessage);
        ObjectNode root = JsonNodeFactory.instance.objectNode();
        root.set("error", errorNode);

        return root.toString();
    }

    public static void updateErrorInResponse(int errorCode, String errorMessage, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(errorCode);

        try {
            response.getWriter().write(Utils.createErrorJSON(errorCode, errorMessage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getDescriptionFromContent(String content) {
        if (content == null || content.length() == 0) {
            return "...";
        }
        if (content.length() > Constants.BLOG_DESCRIPTION_SIZE) {
            content = content.substring(0, Constants.BLOG_DESCRIPTION_SIZE);
        }

        int i = content.lastIndexOf(' ');
        if (i == -1) {
            return "...";
        }

        return content.substring(0, i) + "...";
    }
}
