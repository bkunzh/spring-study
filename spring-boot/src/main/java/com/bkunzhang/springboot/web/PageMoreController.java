package com.bkunzhang.springboot.web;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/4/20
 */
@RestController
public class PageMoreController {
    @CrossOrigin
    @RequestMapping("/pageMore")
    public List<Map> pageMore(int page, int size) {
        String json = FileUtil.readString(PageMoreController.class.getResource(".").getPath() + "/more.json", "utf8");
        List<Map> list = JSON.parseObject(json).getJSONArray("lists").toJavaList(Map.class);
        return list.subList(size * (page - 1), size * page);
    }

}
