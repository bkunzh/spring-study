package com.bkunzh.springaop;

import com.bkunzh.springaop.service.MyService;
import com.bkunzh.springaop.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    static UserService userService;

    //todo spring 注解初始化容器，不用xml
    @BeforeClass
    public static void beforeClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("context created");
        userService = context.getBean(UserService.class);
        // 由于aop，直接属性userService.myService=null , userService.getMyService()通过方法可以获取MyService@593aaf41
        System.out.println("context userService:" + userService + ", " + userService.myService
                + ", " + userService.getMyService());
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
