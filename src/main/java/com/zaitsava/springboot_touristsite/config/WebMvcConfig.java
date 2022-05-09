package com.zaitsava.springboot_touristsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("user/login");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path toutUploadDir= Paths.get("./tour-image/");
        String tourUploadPath=toutUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/tour-image/**").addResourceLocations("file:/"+tourUploadPath+"/");
    }
}