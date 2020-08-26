package com.bkunzhang.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bingkun_zhang
 * @date 2020/8/26
 */
public class TestLog {
    static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("info ...");
        logger.warn("warn ...");
        logger.error("error ...");
    }

}
