package com.bkunzh.springaop;

import com.bkunzh.springaop.config.AppConfig;
import com.bkunzh.springaop.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    static UserService userService;


    //done spring 注解实例化容器，不用xml
    // https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-java-instantiating-container
    @BeforeClass
    public static void beforeClass() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("context created");
        userService = context.getBean(UserService.class);
        // unknown 有疑问
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
    public void objectFunc() {
        System.out.println(userService.toString());
    }


    @Test
    public void around() {
        userService.around("你好啊", 22);
    }
}
