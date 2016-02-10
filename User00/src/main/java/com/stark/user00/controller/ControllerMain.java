package com.stark.user00.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by m on 10/02/2016.
 */
@Controller
public class ControllerMain {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloworld(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }
}
