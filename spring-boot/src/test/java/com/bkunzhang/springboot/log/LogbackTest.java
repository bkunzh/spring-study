package com.bkunzhang.springboot.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bkunzhang on 2019/9/3.
 */
public class LogbackTest {
    static Logger log = LoggerFactory.getLogger(LogbackTest.class);
    static Logger log2 = LoggerFactory.getLogger("xx"); //rootLogger

    @Test
    public void t() {
        log.info("log info");
        log.debug("log debug");

        log2.info("log2.info");
        log2.debug("log2.debug");
    }
}
