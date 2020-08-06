package com.bkunzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bingkun_zhang
 * @date 2020/8/6
 */
@RequestMapping("/bk")
public class ShutdownController {
    private static final Logger log = LoggerFactory.getLogger(ShutdownController.class);

    // 结束进程
    @PostMapping("/shutdown")
    public String shutdown() {
        log.info("结束进程");
        System.exit(0);
        return "not return";
    }
}
