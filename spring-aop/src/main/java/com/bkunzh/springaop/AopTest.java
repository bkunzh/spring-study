package com.bkunzh.springaop;

import com.bkunzh.springaop.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    static UserService userService;

    @BeforeClass
    public static void beforeClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        userService = context.getBean(UserService.class);
        System.out.println("init:" + userService);
    }

    @Test
    public void beforeAndAfter() {
        userService.save("小明", 18);
        userService.save("小红", 17);
        userService.get(1);
    }

    @Test
    public void afterThrowing() {
        try {
            userService.ex();
        } catch (Exception e) {
            System.out.println("error1");
        }
    }

    @Test
    public void around() {
        userService.around("你好啊", 22);
    }
}
