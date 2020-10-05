package com.bkunzh.config;

import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.bkunzh")
//@ImportResource("classpath:spring.xml")
@PropertySource("classpath:test1.properties")
@Import(Config2.class)
public class AppConfig {

    @Profile("dev")
    @Bean("myMap")
    public Map<String, Object> devMap() {
        Map<String, Object> tMap = new HashMap<>();
        tMap.put("aa", "dev");
        return tMap;
    }

//    @Profile({"test", "prd"})
    @Profile("!dev") // 非开发环境
    @Bean("myMap")
    public Map<String, Object> testMap() {
        Map<String, Object> tMap = new HashMap<>();
        tMap.put("aa", "test");
        return tMap;
    }
}
