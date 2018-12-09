package com.pc.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created By: Prashant Chaubey
 * Created On: 09-12-2018 11:04
 **/
@Controller
@RequestMapping("/sunshine")
public class SunshineController {

    private static Logger LOGGER = Logger.getLogger(SunshineController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        LOGGER.info("Getting SUNSHINE page");
        return "sunshine";
    }
}
