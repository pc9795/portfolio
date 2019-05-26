package com.pc.controllers;

import com.pc.entities.BlogItem;
import com.pc.entities.WorkItem;
import com.pc.repositories.BlogItemRepository;
import com.pc.repositories.WorkItemRepository;
import com.pc.utils.BlogUtils;
import com.pc.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import static com.pc.utils.Constants.RESUME_FILE_NAME;


/**
 * Controller for the home page.
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 02:20
 **/
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static Logger LOGGER = Logger.getLogger(HomeController.class);
    private BlogItemRepository blogItemRepository;
    private WorkItemRepository workItemRepository;

    @Autowired
    public HomeController(BlogItemRepository blogItemRepository, WorkItemRepository workItemRepository) {
        this.blogItemRepository = blogItemRepository;
        this.workItemRepository = workItemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        LOGGER.debug("Getting HOME page!");
        List<BlogItem> blogItems = blogItemRepository.findTop3BlogItemsByOrderByTimestampDesc();
        List<WorkItem> workItems = workItemRepository.findTop2ByOrderByTimestampDesc();
        // If there is no description create one from content.
        blogItems.forEach(BlogUtils::checkAndFillDescriptionIfNot);
        model.addAttribute("blogItems", blogItems);
        model.addAttribute("workItems", workItems);
        return "home";
    }

    @RequestMapping(value = "resume")
    public void resume(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=PrashantChaubey_resume.pdf");
        FileInputStream pdfFileStream = null;
        OutputStream responseStream;
        try {
            String resumeFilePath = request.getSession().getServletContext().getRealPath("/resources/" + RESUME_FILE_NAME);
            LOGGER.debug(resumeFilePath);
            pdfFileStream = new FileInputStream(new File(resumeFilePath));
            int readData = 0;
            responseStream = response.getOutputStream();
            for (; (readData = pdfFileStream.read()) != -1; ) {
                responseStream.write(readData);
            }
            responseStream.flush();
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            if (pdfFileStream != null) {
                try {
                    pdfFileStream.close();
                } catch (Exception exc) {
                    LOGGER.error("Error in closing pdf stream");
                }
            }
        }
    }
}
