package com.bkunzh.springaop.service.testfinal;

import org.springframework.stereotype.Service;

@Service
public final class JDKService implements IJDKService {

    @Override
    public final String say(String msg) {
        System.out.println("JDKService say()" + msg);
        return "JDKService say " + msg;
    }
}
