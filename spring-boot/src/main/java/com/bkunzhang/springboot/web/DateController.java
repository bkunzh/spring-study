package com.bkunzhang.springboot.web;

import com.bkunzhang.springboot.util.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by bkunzhang on 2019/7/11.
 * jdk8一些日期的应用
 */
@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping("/getDistanceOfTwoDate")
    public long getDistanceOfTwoDate(String date1, String date2) {
        LocalDate localDate1 = DateUtil.str2LocalDate(date1);
        LocalDate localDate2 = DateUtil.str2LocalDate(date2);
        return DateUtil.getDistanceOfTwoDate(localDate1, localDate2);
    }


}
