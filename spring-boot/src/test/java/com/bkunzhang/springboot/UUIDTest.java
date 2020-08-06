package com.bkunzhang.springboot;

import org.junit.Test;

import java.util.UUID;

/**
 * @author bingkun_zhang
 * @date 2020/6/1
 */
public class UUIDTest {
    @Test
    public void t() {
        System.out.println(UUID.randomUUID().toString());
    }
}
