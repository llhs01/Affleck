package com.affleck.Affleck.controller.ManagementBackStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lianglei on 2018/8/12.
 */
@Controller
@RequestMapping("/managementBackStage")
public class ManagementBackStageHome {

    @RequestMapping("/login")
    public ModelAndView returnHomePage(ModelAndView modelAndView) {
        System.out.print("aaaaaaaaaaaa");
        modelAndView.setViewName("/ManagementBackStage/login");
        return modelAndView;
    }

}
