package com.bkunzh;

import com.alibaba.fastjson.JSON;
import com.bkunzh.config.AppConfig;
import com.bkunzh.config.Config2;
import com.bkunzh.config.UrlConfig;
import com.bkunzh.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ConfigTest {
    // 指定激活的环境，运行时增加jvm参数 -Dspring.profiles.active=dev
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        log.info("" + JSON.toJSONString(context.getEnvironment().getActiveProfiles()));
        log.info("" + context.getBean(UrlConfig.class));
        log.info("" + context.getBean("myStr2"));
        log.info("" + context.getBean("myStr"));
        log.info("" + context.getBean(Config2.class));

        log.info("" + context.getBean("tMap"));
        log.info("" + context.containsBean("mymap"));

        log.info("------------");
        MyService myService = context.getBean(MyService.class);
        myService.say();

//        context.getEnvironment().setActiveProfiles("test"); // 这句没作用？？
        log.info("profile: myMap={}", JSON.toJSONString(context.getBean("myMap")));

    }
}
