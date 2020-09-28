package com.bkunzh.springaop.service.testfinal;

import com.bkunzh.springaop.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CglibService {
    @Autowired
    public MyService myService;
    public final String say(String msg) {
//    public String say(String msg) {
        System.out.println("CglibService say()" + msg);
        return "CglibService say " + msg;
    }
}
