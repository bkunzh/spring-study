package study.springboot2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bkunzh
 * @date 2020/10/8
 */
@RestController
public class GitConfigController {
    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @GetMapping("/testConfig")
    public String say() {
        return env + " " + username;
    }
}
