package com.wind.valley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ComponentScan
 * @EnableAutoConfiguration
 * @Configuration 这三个相当于SpringBootApplication
 */

//("application.controller,application.service,application.httphandler")
@SpringBootApplication
//(scanBasePackages = ("application.controller,application.service,application.httphandler"))//相当于下边的三个注解
@ComponentScan(basePackages = ("application.controller,application.service,application.httphandler"))
public class Application extends SpringBootServletInitializer {
    private static Class<Application> applicationClass = Application.class;

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}

