package com.bkunzh.webtest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/7/15
 */
@RestController
public class TestController {
    @RequestMapping("/workorder/list")
    public ReturnObject list(@RequestBody ListQueryRequest queryRequest) {
        System.out.println(queryRequest.toString());
        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(0);
        return returnObject;
    }
}
