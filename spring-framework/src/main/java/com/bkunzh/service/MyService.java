package com.bkunzh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {
    @Autowired
    private Environment environment;
    @Value("${spring_env}")
    private String springEnv;
    @Value("${a.b.c:ttt}")
    private String pro;
    @Value("${t.aa:ttt}")
    private String pro2;

    public MyService() {
        log.info("init MyService");
    }

    public void say() {
        log.info(environment.getProperty("spring_env"));
        log.info(springEnv);
        log.info(pro);
        log.info("pro2={}", pro2);
    }

}
