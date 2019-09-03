package com.bkunzhang.springboot.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bkunzhang on 2019/9/3.
 */
public class LogbackTest {
    static Logger log = LoggerFactory.getLogger(LogbackTest.class);
    static Logger log2 = LoggerFactory.getLogger("log_name");

    @Test
    public void t() {
        log.info("log_name={}", log.getName());
        log2.info("ok log2");
        log2.debug("debug info 222");
        log.debug("debug info 111111111");
    }
}
