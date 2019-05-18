package com.pc.controllers;

import com.pc.entities.ContactForm;
import com.pc.repositories.ContactFormRepository;
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
        LOGGER.debug("Getting CONTACT page!");
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postContactForm(@Valid ContactForm contactForm, Errors errors, Model model) {
        LOGGER.debug("Form details:" + contactForm);
        LOGGER.warn("Errors:" + errors);
        LOGGER.debug("Submittng Contact form");
        if (!errors.hasErrors()) {
            model.addAttribute("success", true);
            repository.save(contactForm);
            LOGGER.debug("Details saved Successfully!");
        }
        return "contact";
    }
}
