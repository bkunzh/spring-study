package study.springboot2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.springboot2.service.UserService;

/**
 * @author bingkun_zhang
 * @date 2020/8/19
 */
public class SpringFrameworkTest {
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context.getBean(UserService.class));
    }
}
