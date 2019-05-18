package com.pc.controllers;

import com.pc.entities.TutorialItem;
import com.pc.entities.TutorialTag;
import com.pc.repositories.TutorialItemRepository;
import com.pc.repositories.TutorialTagRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 15:25
 **/
@RequestMapping("/tutorial")
@Controller
public class TutorialController {
    @Autowired
    TutorialTagRepository tutorialTagRepository;
    @Autowired
    TutorialItemRepository tutorialItemRepository;
    private static final Logger LOGGER = Logger.getLogger(TutorialController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String tutorial(Model model) {
        List<TutorialItem> tutorialItems = tutorialItemRepository.findTutorialItemsByOrderByTimestampDesc();
        LOGGER.debug("tutorialItems:" + tutorialItems.size());
        addTutorialsAndTagsToModel(model, getAllTags(), tutorialItems);
        return "tutorial";
    }

    @RequestMapping(value = "/month/{month_year}", method = RequestMethod.GET)
    public String tutorialsByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        LOGGER.debug("Getting tutorials for:" + monthYear);
        List<TutorialItem> tutorialItems = tutorialItemRepository.findTutorialItemsByMonthsAndYear(monthYear);
        addTutorialsAndTagsToModel(model, getAllTags(), tutorialItems);
        return "tutorial";
    }

    @RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
    public String tutorialsByYear(@PathVariable(value = "year") String year, Model model) {
        LOGGER.debug("Getting tutorials for:" + year);
        List<TutorialItem> tutorialItems = tutorialItemRepository.findTutorialItemsByYear(year);
        addTutorialsAndTagsToModel(model, getAllTags(), tutorialItems);
        return "tutorial";
    }

    @RequestMapping(value = "/tag/{tag_id}", method = RequestMethod.GET)
    public String tutorialsByTag(@PathVariable(value = "tag_id") String tagId, Model model) {
        LOGGER.debug("Getting tutorials for:" + tagId);
        TutorialTag tutorialTag = tutorialTagRepository.findTutorialTagById(Long.parseLong(tagId));
        addTutorialsAndTagsToModel(model, getAllTags(), tutorialTag.getTutorialItems());
        return "tutorial";
    }


    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public String tutorialsBySearchText(@RequestParam("search_text") String searchText, Model model) {
        LOGGER.debug("Getting tutorials for:" + searchText);
        List<TutorialItem> tutorialItems = tutorialItemRepository.findTutorialItemsByHeadingContaining(searchText);
        addTutorialsAndTagsToModel(model, getAllTags(), tutorialItems);
        return "tutorial";
    }

    @RequestMapping(value = "/single/{tutorial_id}", method = RequestMethod.GET)
    public String singleTutorial(@PathVariable("tutorial_id") String tutorialId, Model model) {
        LOGGER.debug("Getting tutorial for id:" + tutorialId);
        TutorialItem tutorialItem = tutorialItemRepository.findTutorialItemById(Long.parseLong(tutorialId));
        model.addAttribute("tutorialItem", tutorialItem);
        return "tutorial_single";
    }

    //    Helper method
    private List<TutorialTag> getAllTags() {
        List<TutorialTag> tutorialTags = tutorialTagRepository.findAll();
        LOGGER.debug("tutorialTags:" + tutorialTags.size());
        return tutorialTags;
    }

    //  Helper method
    private void addTutorialsAndTagsToModel(Model model, Collection<TutorialTag> tutorialTags, Collection<TutorialItem> tutorialItems) {
        model.addAttribute("tutorialTags", tutorialTags);
        model.addAttribute("tutorialItems", tutorialItems);
    }

}
