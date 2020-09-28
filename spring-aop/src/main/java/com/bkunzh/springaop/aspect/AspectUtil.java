package com.bkunzh.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

public class AspectUtil {
    public static Object doAround(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String pre = pjp.getTarget().getClass().getSimpleName() + " " + methodSignature.getMethod().getName();
        System.out.println(pre + " args: " + Arrays.toString(pjp.getArgs()));

        try {
            Object rs = pjp.proceed();
            System.out.println(pre + " rs: " + rs);
            return rs;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
