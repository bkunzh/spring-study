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
