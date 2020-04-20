package com.bkunzhang.springboot.io;

import cn.hutool.core.io.FileUtil;
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
}
