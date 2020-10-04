package com.bkunzh.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.bkunzh")
//@Profile("test")
@ImportResource("classpath:spring.xml")
@Import(Config2.class)
public class AppConfig {

}
