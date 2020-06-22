import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @author bingkun_zhang
 * @date 2020/6/3
 */
public class Hello {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object user = context.getBean(UserService.class);
        System.out.println(user);
    }
}
