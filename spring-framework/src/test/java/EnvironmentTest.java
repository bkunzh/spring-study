import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

public class EnvironmentTest {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Environment env = context.getEnvironment();
        System.out.println(JSON.toJSONString(env.getDefaultProfiles()));
        System.out.println(JSON.toJSONString(env.getActiveProfiles()));
        System.out.println(env.getProperty("JAVA_HOME"));
        System.out.println(env.getProperty("spring.profiles.active"));
    }

    @Test 
    public void t2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableEnvironment env = context.getEnvironment();
        env.addActiveProfile("dev2");
//        env.setActiveProfiles("dev", "test");
        System.out.println(env.getProperty("spring.profiles.active"));
        System.out.println(JSON.toJSONString(env.getActiveProfiles()));

//        env.getPropertySources().addFirst();
    }
}
