package com.bkunzh.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestFinalAspect {
//    @Pointcut("execution(public * com..*Service.*(..))")
//    @Pointcut("execution(public * com..*.*(..))")
    @Pointcut("execution(public * *..*.*(..))")
//    @Pointcut("execution(public * *..CglibService.*(..))")
//    @Pointcut("execution(public * com..CglibService.*(..))")
    public void allMethodPoint() {}

//    @Around("execution(public * com.bkunzh.springaop.service.testfinal.*.say(..))")
//    @Around("execution(public * com.bkunzh.springaop.service.testfinal.*.toString())")
    @Before("allMethodPoint()")
    public void before() {
        System.out.println("beforeAll22");
    }

//    @Around("execution(public * com..*Service.*(..))")
    @Around("allMethodPoint()")
    public Object around(ProceedingJoinPoint pjp) {
        return AspectUtil.doAround(pjp);
    }

}
