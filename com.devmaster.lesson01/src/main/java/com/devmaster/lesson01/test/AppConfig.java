package com.devmaster.lesson01.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String appName() {
        return "<h1> VIỆN DEVMASTER </h1>";
    }
}
