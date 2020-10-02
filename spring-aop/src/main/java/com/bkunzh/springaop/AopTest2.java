package com.bkunzh.springaop;

import com.bkunzh.springaop.config.AppConfig;
import com.bkunzh.springaop.service.testfinal.CglibService;
import com.bkunzh.springaop.service.testfinal.IJDKService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

// cglib、jdk
public class AopTest2 {
    static IJDKService ijdkService;
    static CglibService cglibService;

    @BeforeClass
    public static void beforeClass() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ijdkService = context.getBean(IJDKService.class);
        cglibService = context.getBean(CglibService.class);
    }

    // cglib，基于继承实现，不会代理final方法；jdk由于是基于接口代理，可以代理final方法
    @Test
    public void finalMethodTest() {
        System.out.println(ijdkService.getClass().getName() + ", " + cglibService.getClass().getName());
        System.out.println(ijdkService.getClass().getSuperclass().getName()); // java.lang.reflect.Proxy
        System.out.println(cglibService.getClass().getSuperclass().getName()); // com.bkunzh.springaop.service.testfinal.CglibService
        System.out.println("##" + Arrays.toString(ijdkService.getClass().getInterfaces()));
        System.out.println("##" + Arrays.toString(cglibService.getClass().getInterfaces()));
        System.out.println("jdk 代理:");
        System.out.println(ijdkService.say("1"));
        System.out.println("cglib代理:");
        System.out.println(cglibService.say("2"));

    }

    @Test
    public void objectFunc() {
        System.out.println("toString  方法:");
        System.out.println(ijdkService.toString());
        System.out.println(cglibService.toString());
    }

}
