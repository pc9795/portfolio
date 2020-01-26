package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.WorkItem;
import com.prashantchaubey.repositories.jpa.WorkItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 15:21
 **/
@Controller
@RequestMapping("/works")
public class WorkController {

    private WorkItemRepository workItemRepository;

    @Autowired
    public WorkController(WorkItemRepository repository) {
        this.workItemRepository = repository;
    }

    /**
     * Get the work page
     *
     * @param model model to pass to JSP
     * @return the view name
     */
    @GetMapping
    public String work(Model model) {
        List<WorkItem> workItems = workItemRepository.findByOrderByCreatedAtDesc();
        model.addAttribute("workItems", workItems);
        return "work";
    }
}
