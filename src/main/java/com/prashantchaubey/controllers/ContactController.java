package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.ContactForm;
import com.prashantchaubey.repositories.ContactFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    private ContactFormRepository repository;
    private static Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    public ContactController(ContactFormRepository contactFormRepository) {
        this.repository = contactFormRepository;
    }

    @GetMapping
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping
    public String postContactForm(@Valid ContactForm contactForm, Errors errors, Model model) {
        LOGGER.debug("Form details:" + contactForm);
        LOGGER.warn("Errors:" + errors);
        if (!errors.hasErrors()) {
            model.addAttribute("success", true);
            repository.save(contactForm);
            LOGGER.debug("Details saved Successfully!");
        }
        return "contact";
    }
}
