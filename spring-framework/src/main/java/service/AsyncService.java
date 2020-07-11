package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import util.ThreadUtil;

/**
 * @author bingkun_zhang
 * @date 2020/6/20
 */
public class AsyncService implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void f1() {
        sleep();
        ThreadUtil.printThreadInfo();
        log.info("f1 end");
    }

    @Async
    public void f2() {
        synchronized (AsyncService.class) {
            sleep();
            ThreadUtil.printThreadInfo();
            log.info("f2 end");
        }
    }

    public void f3() {
        synchronized (AsyncService.class) {
            f2();
            ThreadUtil.printThreadInfo();
            log.info("f3 end");
        }
    }

    public void f4() {
        synchronized (AsyncService.class) {
            AsyncService asyncService = this.applicationContext.getBean(AsyncService.class);
            System.out.println("this=asyncService? " + (this == asyncService));
            asyncService.f2();
            log.info("f4 end");
        }
    }

    private void sleep()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
