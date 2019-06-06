package com.bkunzhang.springboot.web;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bkunzhang on 2019/6/6.
 * 请求见postman
 */
@RestController
public class PostDataController {

    @Data
    public static class TestParentToString {
        private int a = 55;
        private String b = "haha";
    }

    @Data
    public static class Request extends TestParentToString {
        private String name;
        private int age;
        private List<String> mobiles;
        private String other;

        @Override
        public String toString() {
            return "Request{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", mobiles=" + mobiles +
                    ", other='" + other + '\'' +
                    "} " + super.toString();
        }
    }

    @RequestMapping("/postData")
    public String postData(@RequestParam String name, Request request) {
        System.out.println(request);
        return "Happy every day!";
    }
}
