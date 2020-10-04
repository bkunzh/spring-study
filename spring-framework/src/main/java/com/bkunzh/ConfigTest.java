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
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        log.info("" + JSON.toJSONString(context.getEnvironment().getActiveProfiles()));
//        context.getEnvironment().setActiveProfiles("test");
        log.info("" + context.getBean(UrlConfig.class));
        log.info("" + context.getBean("myStr2"));
        log.info("" + context.getBean("myStr"));
        log.info("" + context.getBean(Config2.class));

        log.info("" + context.getBean("tMap"));
        log.info("" + context.containsBean("mymap"));

        log.info("------------");
        MyService myService = context.getBean(MyService.class);
        myService.say();

    }
}
