package com.affleck.Affleck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lianglei on 2018/6/18.
 */
@Controller
@RequestMapping("/index")
public class HomePage {


    @RequestMapping("")
    public ModelAndView returnHomePage(ModelAndView modelAndView) {
        System.out.print("aaaaaaaaaaaa");
        modelAndView.setViewName("/index");
        return modelAndView;
    }



}
