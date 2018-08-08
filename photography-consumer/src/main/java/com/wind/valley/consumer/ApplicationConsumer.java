package com.wind.valley.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @ComponentScan
 * @EnableAutoConfiguration
 * @Configuration 这三个相当于SpringBootApplication
 */


@SpringBootApplication
@EnableDubboConfig
@ComponentScan("com.wind.valley")
@ImportResource(locations = ("classpath:consumer.xml"))
public class ApplicationConsumer extends SpringBootServletInitializer {
    private static Class<ApplicationConsumer> applicationClass = ApplicationConsumer.class;

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}

