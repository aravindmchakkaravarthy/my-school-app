package com.myschool.myschoolapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(PlayController.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("Incoming request");
        registry.addMapping("/**");
    }
}
