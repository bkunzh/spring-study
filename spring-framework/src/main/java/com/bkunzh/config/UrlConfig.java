package com.bkunzh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UrlConfig {
    @Bean
    public String myStr2() {
        return "myStr2 " + new Date();
    }
}
