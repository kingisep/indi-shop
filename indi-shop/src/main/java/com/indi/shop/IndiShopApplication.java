package com.indi.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.indi")
public class IndiShopApplication extends SpringBootServletInitializer {
    
    private static final Class<IndiShopApplication> APP = IndiShopApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(APP);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(APP);
    }

}
