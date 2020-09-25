package com.bkunzh.springaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.bkunzh")
@EnableAspectJAutoProxy
public class AppConfig {
}
