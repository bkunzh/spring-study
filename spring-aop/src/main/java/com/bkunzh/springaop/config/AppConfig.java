package com.bkunzh.springaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.bkunzh")
@EnableAspectJAutoProxy // 自动选择，有接口会自动选择jdk动态代理，否则使用cglib代理
//@EnableAspectJAutoProxy(proxyTargetClass = true) // 强制使用cglib代理
public class AppConfig {
}
