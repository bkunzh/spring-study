package com.bkunzh;

import com.alibaba.fastjson.JSON;
import com.bkunzh.dto.MyBean;
import com.bkunzh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/6/3
 */
@Slf4j
public class XmlTest {
    public static void main(String[] args) {
        // 指定激活的环境，运行时增加jvm参数 -Dspring.profiles.active=dev
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        log.info("" + userService);
        log.info("" + userService.myService);
        userService.myService.say();

        // env profile 实现方式1:在开发环境环境变量spring_env设置为dev，测试环境环境变量spring_env设置为test
        log.info("" + "环境变量spring_env=" + context.getEnvironment().getProperty("spring_env"));
        MyBean myBean = context.getBean("myBean", MyBean.class);
        log.info("" + JSON.toJSONString(myBean));

        // 构造器声明map
        log.info("" + JSON.toJSONString(context.getBean("mymap")));

        // Profile使用
        log.info("profile: myMap={}", JSON.toJSONString(context.getBean("myMap")));
    }
}
