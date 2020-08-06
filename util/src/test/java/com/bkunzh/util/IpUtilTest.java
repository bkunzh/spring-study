package com.bkunzh.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * @author bingkun_zhang
 * @date 2020/6/22
 */
@RunWith(Parameterized.class)
public class IpUtilTest {

    // 单元测试执行多次
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[20][0]; // repeat count which you want
    }

    @Test
    public void getRandomIp() {
        System.out.println(IpUtil.getRandomIp());
    }
}