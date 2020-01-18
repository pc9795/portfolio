package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.ListItem;
import com.prashantchaubey.repositories.ListItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ListsController.class);

    @Autowired
    public ListsController(ListItemRepository listItemRepository) {
        this.repository = listItemRepository;
    }

    @GetMapping
    public String lists(Model model) {
        List<ListItem> casualReadingList = repository.findListItemsByType(ListItem.Type.CASUAL);
        LOGGER.debug("Casual:" + casualReadingList.size());
        List<ListItem> technicalReadingList = repository.findListItemsByType(ListItem.Type.TECHNICAL);
        LOGGER.debug("Technical:" + technicalReadingList.size());
        List<ListItem> gamingReadingList = repository.findListItemsByType(ListItem.Type.GAMING);
        LOGGER.debug("Gaming:" + gamingReadingList.size());
        model.addAttribute("casualReadingList", casualReadingList);
        model.addAttribute("technicalReadingList", technicalReadingList);
        model.addAttribute("gamingReadingList", gamingReadingList);
        return "lists";
    }
}
