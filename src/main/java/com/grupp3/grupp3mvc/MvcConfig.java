package com.grupp3.grupp3mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//     registry.addViewController("/home").setViewName("home");
//     registry.addViewController("/").setViewName("home");
    }

//    public WebMvcConfigurer corsConfigurer() {
//
//        return new corsConfigurer() {
//
//            @Override
//            public void addCorsMappings (CorsRegistry registry){
//
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8081");
//            }
//        };
//    }

}
