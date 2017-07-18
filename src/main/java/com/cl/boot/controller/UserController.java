package com.cl.boot.controller;

import com.cl.boot.api.UserService;
import com.cl.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Test
 * Created by MrC on 2017/6/20
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("/user");
    }

}
