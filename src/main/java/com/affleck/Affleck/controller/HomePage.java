package com.affleck.Affleck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lianglei on 2018/6/18.
 */
@Controller
@RequestMapping("/")
public class HomePage {


    @RequestMapping("/helloworld")
    @ResponseBody
    public String returnHomePage() {
        return "hello world";
    }



}
