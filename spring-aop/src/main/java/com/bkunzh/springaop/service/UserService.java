package com.bkunzh.springaop.service;

import com.bkunzh.springaop.aspect.MyAnno;
import com.bkunzh.springaop.aspect.MyAnno2;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void save(String name, Integer age) {
        System.out.println("保存用户");
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
