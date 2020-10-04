import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bkunzh.service.AsyncService;

/**
 * @author bingkun_zhang
 * @date 2020/6/20
 */
@RunWith(Parameterized.class)
public class AsyncTest {
    private static final Logger log = LoggerFactory.getLogger(AsyncTest.class);

    // 单元测试执行多次
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0]; // repeat count which you want
    }

    // 多线程运行的不确定性 test、test2都运行10次， 观察下时间和输出。test2让锁了，总体稳定；test多次结果差异大
    // 使用默认的SimpleAsyncTaskExecutor，每执行一个Task开启一个线程，有的f1、f2都执行了2次，奇怪。换成spring线程池试试，也是
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AsyncService asyncService = context.getBean(AsyncService.class);
        asyncService.f1();

        asyncService.f2();
        log.info("main end");
        // 稍后再获取锁
//        sleep50();
        synchronized (AsyncService.class) {
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AsyncService asyncService = context.getBean(AsyncService.class);
        asyncService.f1();

        asyncService.f2();
        log.info("main end");
        // 稍后再获取锁
        sleep50();
        synchronized (AsyncService.class) {
        }
    }

    private void sleep50() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
