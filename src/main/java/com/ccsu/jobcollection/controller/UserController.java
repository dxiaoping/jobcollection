package com.ccsu.jobcollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-27 17:07
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    @ResponseBody
    public String login(){
        System.out.println("login...");
        return "SUCCESS";
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(){
        System.out.println("login...");
        return "SUCCESS";
    }
}
