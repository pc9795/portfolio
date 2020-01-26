package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.ContactForm;
import com.prashantchaubey.repositories.jpa.ContactFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Controller for ContactMe page.
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 02:19
 **/

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

    private ContactFormRepository repository;
    private static Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    public ContactController(ContactFormRepository contactFormRepository) {
        this.repository = contactFormRepository;
    }

    /**
     * Get contact page
     *
     * @param model model to pass to JSP
     * @return the view name
     */
    @GetMapping
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    /**
     * Get the contact form
     *
     * @param contactForm contact data
     * @param errors      validation errors
     * @param model       model to pass to JSP
     * @return the view name
     */
    @PostMapping
    public String postContactForm(@Valid ContactForm contactForm, Errors errors, Model model) {
        LOGGER.warn("Errors:" + errors);
        if (!errors.hasErrors()) {
            model.addAttribute("success", true);
            repository.save(contactForm);
        }
        return "contact";
    }
}
