package com.bkunzhang.web_file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bingkun_zhang
 * @date 2020/3/31
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "hello, " + sdf.format(new Date());
    }
}
