package com.bkunzh.config;

import org.springframework.context.annotation.Bean;

import java.util.Date;

public class Config2 {
    @Bean("myStr")
    public String myStr() {
        return "myStr " + new Date();
    }
}
