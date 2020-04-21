package com.bkunzhang.springboot.io;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;

/**
 * @author bingkun_zhang
 * @date 2020/4/20
 */
public class HutoolTests {
    @Test
    public void readFile() {
        System.out.println(HutoolTests.class.getResource(".").getPath());
        String text = FileUtil.readString(HutoolTests.class.getResource(".").getPath() + "/more.json", "utf-8");
        System.out.println(text);
    }

    @Test
    public void writeFile() {
        String path = HutoolTests.class.getResource(".").getPath() + "/more.json";
        String text = FileUtil.readString(path, "utf-8");
        JSONArray jsonArray = JSON.parseObject(text).getJSONArray("lists");
        System.out.println(jsonArray.size());
//        JSONArray arrayRs = JSON.parseArray(JSON.toJSONString(jsonArray));
        int oriLen = jsonArray.size();
        // 添加2倍的现有数据，link从#16开始递增
        for (int i=0; i<2; ++i) {
            for (int j=0; j<oriLen; ++j) {
                String link = "#" + (oriLen + 1 + oriLen * i + j);
                JSONObject item = JSON.parseObject(JSON.toJSONString(jsonArray.get(j)));
                item.put("link", link);
                jsonArray.add(item);
                System.out.println(item.get("link"));
            }
        }
        System.out.println("result jsonArray size = " + jsonArray.size());
        JSONObject rs = new JSONObject();
        rs.put("lists", jsonArray);
        FileUtil.writeString(JSON.toJSONString(rs), path, "utf8");
        System.out.println("result path=" + path);
    }
}
