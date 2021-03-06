package com.bkunzh.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    /*
    声明切入点
    https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop-pointcuts-designators
     */
    // done 怎样增加参数
    @Pointcut("execution(public void com..*.UserService.save(..)) && args(name,age)")
    public void pointcut1(String name, Integer age) {}

//    @Before("execution(public void com..*.UserService.*(..))")
//    @Before("execution(public * com..*.UserService.*(..))")
    // 不要public修饰符默认所有
    @Before("execution(* com..*.UserService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + " " + joinPoint.getSignature().getName()
                + " before args: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before1");
    }

    @Before("pointcut1(name, age)")
    public void before2(String name, Integer age) {
        System.out.println("before2: " + name + ", " + age);
    }

    // Error
//    @Before(value = "execution(public * com..*.UserService.save(name,age))", argNames = "name,age")
//    public void before2_2(String name, Integer age) {
//        System.out.println("before2_2 " + name + ", " + age);
//    }

//    @Pointcut("execution(public * com..*.UserService.*(..))")
    @Pointcut("execution(public * com..UserService.*(..))")
    public void userServiceAllMethodPoint() {}

    @Before("userServiceAllMethodPoint()")
    public void beforeAllMethod() {
        System.out.println("beforeAll11");
    }

    @After(value = "userServiceAllMethodPoint()")
    public void after(JoinPoint joinPoint) {
        System.out.println("jp: " + joinPoint.getTarget() + ", " + joinPoint.getSignature().getName() + ", "
                + Modifier.toString(joinPoint.getSignature().getModifiers()) + ", "
                + Arrays.toString(joinPoint.getArgs()));
        System.out.println("after finally");
    }

    @AfterReturning(value = "execution(public * com..*.UserService.*(..))", returning = "rs")
    public void afterReturning(Object rs) {
        System.out.println("afterReturning: " + rs);
    }



    @AfterThrowing(value = "@annotation(com.bkunzh.springaop.aspect.MyAnno)", throwing = "ex")
    public void afterThrowing(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        System.out.println("afterThrowing:" + stringWriter.toString());
    }

    @Around(value = "@annotation(com.bkunzh.springaop.aspect.MyAnno2)")
    public Object around(ProceedingJoinPoint pjp) {
        return AspectUtil.doAround(pjp);
    }


}
