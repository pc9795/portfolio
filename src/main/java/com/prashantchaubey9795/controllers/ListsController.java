package com.prashantchaubey9795.controllers;

import com.prashantchaubey9795.beans.ListItemTypes;
import com.prashantchaubey9795.entities.ListItem;
import com.prashantchaubey9795.repositories.ListItemRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Controller for lists page.
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:39
 **/
@Controller
@RequestMapping("/lists")
public class ListsController {

    @Autowired
    ListItemRepository repository;
    private static final Logger LOGGER = Logger.getLogger(ListsController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String lists(Model model) {
        List<ListItem> casualReadingList = repository.findListItemsByType(ListItemTypes.CASUAL);
        LOGGER.info("casualReadingList:" + casualReadingList);
        List<ListItem> technicalReadingList = repository.findListItemsByType(ListItemTypes.TECHNICAL);
        LOGGER.info("technicalReadingList:" + technicalReadingList);
        List<ListItem> gamingReadingList = repository.findListItemsByType(ListItemTypes.GAMING);
        LOGGER.info("gamingReadingList:" + gamingReadingList);
        model.addAttribute("casualReadingList", casualReadingList);
        model.addAttribute("technicalReadingList", technicalReadingList);
        model.addAttribute("gamingReadingList", gamingReadingList);
        return "lists";
    }
}
