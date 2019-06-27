package com.bkunzhang.springboot.springbean;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by bkunzhang on 2019/6/27.
 */
public class TestCopyProperties {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        A a = new A("11", "aa");
        System.out.println(JSON.toJSONString(a));
        B b = new B();
        BeanUtils.copyProperties(a, b);
        System.out.println(JSON.toJSONString(b));

        org.apache.commons.beanutils.BeanUtils.copyProperties(a, b);
        System.out.println(JSON.toJSONString(b));
    }

    static class A {
        String a;
        String b;

        public A(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String getA() {
            return a + "xxxx";
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    static class B {
        String a;
        String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
