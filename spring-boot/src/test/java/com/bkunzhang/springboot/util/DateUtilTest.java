package com.bkunzhang.springboot.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by bkunzhang on 2019/7/11.
 */
public class DateUtilTest {

    String dateStr1;
    String dateStr2;
    LocalDate  localDate1;
    LocalDate localDate2;

    static Logger log = LoggerFactory.getLogger(DateUtilTest.class);

    @Before
    public void before() {
        dateStr1 = "2019-02-26";
        dateStr2 = "2019-04-02";
        localDate1 = DateUtil.str2LocalDate(dateStr1);
        localDate2 = DateUtil.str2LocalDate(dateStr2);
    }

    @Test
    public void getDistanceOfTwoDate() throws Exception {
        assertEquals(35L, DateUtil.getDistanceOfTwoDate(localDate1, localDate2));
        log.info("DateUtilTest getDistanceOfTwoDate yes 2");
    }

    @Test
    public void str2LocalDate() throws Exception {
        assertEquals(LocalDate.of(2019, 2, 26), DateUtil.str2LocalDate(dateStr1));
    }

}