package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.WorkItem;
import com.prashantchaubey.repositories.WorkItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/work")
public class WorkController {

    private WorkItemRepository workItemRepository;

    @Autowired
    public WorkController(WorkItemRepository repository) {
        this.workItemRepository = repository;
    }

    @GetMapping
    public String work(Model model) {
        Sort descendingOrder = new Sort(Sort.Direction.DESC, "timestamp");
        List<WorkItem> workItems = workItemRepository.findAll(descendingOrder);
        model.addAttribute("workItems", workItems);
        return "work";
    }
}
