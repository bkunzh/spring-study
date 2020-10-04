package com.bkunzh;

import com.alibaba.fastjson.JSON;
import com.bkunzh.config.AppConfig;
import com.bkunzh.config.UrlConfig;
import com.bkunzh.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(JSON.toJSONString(context.getEnvironment().getActiveProfiles()));
//        context.getEnvironment().setActiveProfiles("test");
        System.out.println(context.getBean(UrlConfig.class));
        System.out.println(context.getBean("myStr2"));
        System.out.println(context.getBean("myStr"));
        System.out.println(context.getBean(MyService.class));
    }
}
