package com.pc.controllers;

import com.pc.beans.ListItemTypes;
import com.pc.entities.ListItem;
import com.pc.repositories.ListItemRepository;
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

    ListItemRepository repository;
    private static final Logger LOGGER = Logger.getLogger(ListsController.class);

    @Autowired
    public ListsController(ListItemRepository listItemRepository) {
        this.repository = listItemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lists(Model model) {
        List<ListItem> casualReadingList = repository.findListItemsByType(ListItemTypes.CASUAL);
        LOGGER.debug("casualReadingList:" + casualReadingList.size());
        List<ListItem> technicalReadingList = repository.findListItemsByType(ListItemTypes.TECHNICAL);
        LOGGER.debug("technicalReadingList:" + technicalReadingList.size());
        List<ListItem> gamingReadingList = repository.findListItemsByType(ListItemTypes.GAMING);
        LOGGER.debug("gamingReadingList:" + gamingReadingList.size());
        model.addAttribute("casualReadingList", casualReadingList);
        model.addAttribute("technicalReadingList", technicalReadingList);
        model.addAttribute("gamingReadingList", gamingReadingList);
        return "lists";
    }
}
