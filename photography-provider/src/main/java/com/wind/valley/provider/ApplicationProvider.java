package com.wind.valley.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
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
@ComponentScan("com.wind.valley")
@EnableDubboConfiguration
@ImportResource(locations= {"classpath:provider.xml"})
public class ApplicationProvider extends SpringBootServletInitializer {
    private static Class<ApplicationProvider> applicationClass = ApplicationProvider.class;

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}

