package study.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot2Application {

    // --spring.profiles.active=prod 可以指定环境
    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

}
