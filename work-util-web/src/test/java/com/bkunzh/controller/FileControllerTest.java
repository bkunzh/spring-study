package com.bkunzh.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author bingkun_zhang
 * @date 2020/8/6
 */
public class FileControllerTest {
    @Test
    public void createNewFile() {
        new FileController().fileExists();
    }
}