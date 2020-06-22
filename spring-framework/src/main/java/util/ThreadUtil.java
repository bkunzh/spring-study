package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bingkun_zhang
 * @date 2020/6/20
 */
public class ThreadUtil {
    private static final Logger log = LoggerFactory.getLogger(ThreadUtil.class);

    public static void printThreadInfo() {
        log.debug("thread info: {}, {}", Thread.currentThread().getName(), Thread.currentThread().getId());
    }


}
