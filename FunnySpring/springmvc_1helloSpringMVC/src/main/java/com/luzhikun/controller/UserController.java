package com.luzhikun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller sava running");
            return "success";
    }




}
