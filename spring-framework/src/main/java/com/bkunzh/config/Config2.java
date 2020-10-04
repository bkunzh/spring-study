package com.bkunzh.config;

import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Config2 {
    @Bean("myStr")
    public String myStr() {
        return "myStr " + new Date();
    }

    @Bean
    public Map<String, Object> tMap() {
        Map<String, Object> tMap = new HashMap<>();
        tMap.put("aa", "33");
        return tMap;
    }
}
