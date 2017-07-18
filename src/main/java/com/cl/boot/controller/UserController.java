package com.cl.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 * Created by MrC on 2017/6/20
 */
@RestController
@RequestMapping("/")
public class UserController {


    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("/user");
    }

}
