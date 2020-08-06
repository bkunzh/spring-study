package com.bkunzh.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bingkun_zhang
 * @date 2020/8/6
 */
@RestController
@RequestMapping("/mongoUtil")
public class MongoUtilController {

    @RequestMapping("/robo3TData2JsonArray")
    public String robo3TData2JsonArray(@RequestBody String tableData) {
        String[] lines = tableData.split("\r\n");
        StringBuilder result = new StringBuilder("[\n");
        for (String s : lines) {
            if (s.startsWith("/")) {
                if (!"/* 1 */".equals(s)) {
                    result.append(",");
                }
            } else if (s.isEmpty()) {
            } else {
                result.append(s);
                result.append("\n");
            }
        }
        result.append("]");
        return result.toString();
    }
}
