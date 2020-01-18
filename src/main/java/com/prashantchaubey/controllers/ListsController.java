package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.ListItem;
import com.prashantchaubey.repositories.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Controller for lists page.
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:39
 **/
@Controller
@RequestMapping("/lists")
public class ListsController {

    private ListItemRepository repository;

    @Autowired
    public ListsController(ListItemRepository listItemRepository) {
        this.repository = listItemRepository;
    }

    @GetMapping
    public String lists(Model model) {
        List<ListItem> casualReadingList = repository.findListItemsByType(ListItem.Type.CASUAL);
        List<ListItem> technicalReadingList = repository.findListItemsByType(ListItem.Type.TECHNICAL);
        List<ListItem> gamingReadingList = repository.findListItemsByType(ListItem.Type.GAMING);
        model.addAttribute("casualReadingList", casualReadingList);
        model.addAttribute("technicalReadingList", technicalReadingList);
        model.addAttribute("gamingReadingList", gamingReadingList);
        return "lists";
    }
}
