package com.prashantchaubey9795.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Controller for the home page.
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 02:20
 **/
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static Logger LOGGER = Logger.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        LOGGER.info("Getting HOME page!");
        return "home";
    }

    @RequestMapping(value = "resume")
    public void resume(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=PrashantChaubey_resume.pdf");
        FileInputStream pdfFileStream;
        OutputStream responseStream;
        try {
            String resumeFilePath = request.getSession().getServletContext().getRealPath("/resources/PrashantChaubey_resume.pdf");
            LOGGER.info(resumeFilePath);
            pdfFileStream = new FileInputStream(new File(resumeFilePath));
            int readData = 0;
            responseStream = response.getOutputStream();
            for (; (readData = pdfFileStream.read()) != -1; ) {
                responseStream.write(readData);
            }
            responseStream.flush();
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }
}
