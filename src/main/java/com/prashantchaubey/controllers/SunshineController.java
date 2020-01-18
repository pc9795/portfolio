package com.prashantchaubey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By: Prashant Chaubey
 * Created On: 09-12-2018 11:04
 **/
@Controller
@RequestMapping("/sunshine")
public class SunshineController {

    @GetMapping
    public String home() {
        return "sunshine";
    }
}
