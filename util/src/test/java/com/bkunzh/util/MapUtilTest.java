package com.bkunzh.util;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author bingkun_zhang
 * @date 2020/7/1
 */
public class MapUtilTest {

    @Test
    public void getKeyOfOneKeyMap() throws Exception {
        // JSON.toJSONString 会给字符串添加双引号
        Resource resource = new ClassPathResource("com/bkunzh/util/map.json");
        System.out.println(resource.getURI());
        System.out.println(resource.getURL());
        System.out.println(resource.exists());
        System.out.println(resource.isReadable());
        System.out.println(resource.isOpen());
        System.out.println(resource.getFile().getAbsolutePath());
        System.out.println(resource.getFile().getPath());

//        String json = FileUtil.readString()
    }
}