package com.prashantchaubey.utils;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class Utils {

    private static String createErrorJSON(int errorCode, String errorMessage) {
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

}
