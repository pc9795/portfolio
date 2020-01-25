package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.WorkItem;
import com.prashantchaubey.repositories.BlogItemRepository;
import com.prashantchaubey.repositories.WorkItemRepository;
import com.prashantchaubey.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static com.prashantchaubey.utils.Constants.RESUME_FILE_NAME;


/**
 * Controller for the home page.
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 02:20
 **/
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private BlogItemRepository blogItemRepository;
    private WorkItemRepository workItemRepository;

    @Autowired
    public HomeController(BlogItemRepository blogItemRepository, WorkItemRepository workItemRepository) {
        this.blogItemRepository = blogItemRepository;
        this.workItemRepository = workItemRepository;
    }

    /**
     * Home page
     *
     * @param model model to pass to JSP
     * @return the view name
     */
    @GetMapping
    public String home(Model model) {
        List<BlogItem> blogItems = blogItemRepository.findTop3BlogItemsByOrderByCreatedAtDesc();
        List<WorkItem> workItems = workItemRepository.findTop2ByOrderByCreatedAtDesc();
        model.addAttribute("blogItems", blogItems);
        model.addAttribute("workItems", workItems);
        return "home";
    }

    /**
     * Get the resume
     *
     * @param response response object
     * @param request  request object
     */
    @GetMapping(value = "resume")
    public void resume(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=" + RESUME_FILE_NAME);

        String resumeFilePath = request.getSession().getServletContext().getRealPath("/resources/" + RESUME_FILE_NAME);
        LOGGER.debug("Resume file path:" + resumeFilePath);

        try (FileInputStream pdfFileStream = new FileInputStream(new File(resumeFilePath))) {
            int readData;
            OutputStream responseStream = response.getOutputStream();
            for (; (readData = pdfFileStream.read()) != -1; ) {
                responseStream.write(readData);
            }
            responseStream.flush();

        } catch (Exception ex) {
            LOGGER.error("Error in getting resume:", ex);
            throw ex;
        }
    }
}
