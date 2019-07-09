package com.bkunzhang.springboot.web;

import com.bkunzhang.springboot.util.CommonConstant;
import com.bkunzhang.springboot.vo.Request;
import com.bkunzhang.springboot.vo.RequestAndResponse;
import com.bkunzhang.springboot.vo.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Created by bkunzhang on 2019/6/1.
 */
@Api(tags = "组1")
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Environment env;

    @ApiOperation("获取天气")
    @RequestMapping("/getWeather")
    public Object getWeather(@RequestHeader Map<String, Object> headers, @RequestBody(required = false) Map<String, Object> bodys, HttpServletRequest request) {
        logger.info("HelloController getWeather headers={}, bodys={}", headers, bodys);
        if (!Objects.equals(headers.get(CommonConstant.KEY_AUTHORIZATION), env.getProperty("getWeather.authorization"))) {
            return "authorization error";
        }
        Weather weather = new Weather(new Date(), "多云", 29.8);
        return new RequestAndResponse(new Request(headers, bodys), weather);
    }
}
