package study.springboot2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

//@Component
@RestController
public class TestController {
    @Resource(name = "test")
    Object t;

    Logger log = LoggerFactory.getLogger(TestController.class);


    @PostConstruct
    public void t() {
        log.debug("TestController t= {}, {}", t.getClass().getName(), t.toString());
    }
}
