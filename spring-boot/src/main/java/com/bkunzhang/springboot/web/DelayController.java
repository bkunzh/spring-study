package com.bkunzhang.springboot.web;

import com.bkunzhang.springboot.vo.ReturnCode;
import com.bkunzhang.springboot.vo.ReturnObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模仿接口比较慢，响应时间长
 * @author bingkun_zhang
 * @date 2020/6/9
 */
@RestController
@RequestMapping("/delay")
public class DelayController {

    @CrossOrigin
    @GetMapping("/getData")
    public ReturnObject<?> getData() throws InterruptedException {
        Thread.sleep(3000);
        return ReturnObject.success(new String[] {"aa", "bb", "cc"}).msg("成功");
    }
}
