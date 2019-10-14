package com.bkunzhang.springboot.web;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    //request: Content-Type: application/json {"name":"tom","age":22,"other":"abcde"}
    @RequestMapping("/postData")
    public String postData(@RequestParam(required = false) String name,
                           Request request2, @RequestBody Request request) { //request2 from param, request from request body
        System.out.println(request);
        return "Happy every day!";
    }

    //request: Content-Type: application/x-www-form-urlencoded; charset=UTF-8  name=tom&age=22&other=abcde
    @RequestMapping("/postData2")
    public String postData(Request request2) { //request2 from param, request from request body
        System.out.println(request2);
        return "Happy every day!";
    }

    @RequestMapping("/postFile")
    public String postFile(@RequestParam("file1") MultipartFile file, @RequestParam Map<String, Object> map) throws IOException {
        if (file.isEmpty()) {
            return "file not find";
        }
        System.out.println(file.getOriginalFilename());
        System.out.println("map=" + map);
        String filePath = "d:/t/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        return "yes";
    }
}
