package com.bkunzh.springaop.service;

import com.bkunzh.springaop.aspect.MyAnno;
import com.bkunzh.springaop.aspect.MyAnno2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public MyService myService;

    public UserService() {
        // 构造函数中，myService还没有注入 unknown 有疑问
        // https://blog.csdn.net/dongfengkuayue/article/details/50560188
        System.out.println("UserService myService=" + myService + ", this=" + this);
    }
    public void save(String name, Integer age) {
        System.out.println("保存用户");
    }

    public MyService getMyService() {
        return myService;
    }

    // final方法
//    public final void get(int id) {
    public int get(int id) {
        System.out.println("get()");
        return id;
    }

    public int get2(int id) {
        try {
            System.out.println("get2()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("fin");
        }
        return id;
    }

    // userService.getClass().getPackage().getName()为com.bkunzh.springaop.service，和UserService一个包，所以至少包权限，
    // 才能被cglib生成的子类覆盖这个方法
//    protected int get3(int id) {
    int get3(int id) {
        System.out.println("get3()");
        return id;
    }

    @MyAnno
    public int ex() {
        int a = 0;
        return 2 / a;
    }

    @MyAnno2
    public int around(String name, Integer id) {
        System.out.println("do around");
        return id;
    }
}
