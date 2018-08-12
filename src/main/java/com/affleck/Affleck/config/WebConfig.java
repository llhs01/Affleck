package com.affleck.Affleck.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lianglei on 2017/9/30.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 专门控制页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        super.addViewControllers(registry);
    }
}
