package com.prashantchaubey9795.controllers;

import com.prashantchaubey9795.entities.ContactForm;
import com.prashantchaubey9795.repositories.ContactFormRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for ContactMe page.
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 02:19
 **/

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactFormRepository repository;
    private static Logger LOGGER = Logger.getLogger(ContactController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String contact(Model model) {
        LOGGER.info("Getting CONTACT page!");
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postContactForm(@Valid ContactForm contactForm, Errors errors, Model model) {
        LOGGER.info("Form details:" + contactForm);
        LOGGER.warn("Errors:" + errors);
        LOGGER.info("Submittng Contact form");
        if (!errors.hasErrors()) {
            model.addAttribute("success", true);
            repository.save(contactForm);
            LOGGER.info("Details saved Successfully!");
        }
        return "contact";
    }
}
