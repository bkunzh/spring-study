package com.bkunzhang.springboot.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by bkunzhang on 2019/7/11.
 */
public class DateUtil {

    public final static DateTimeFormatter FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    /** 计算两个日期相隔天数
     * @param localDate1 开始日期
     * @param localDate2 结束日期
     * @return 相隔天数
     */
    public static long getDistanceOfTwoDate(LocalDate localDate1, LocalDate localDate2) {
        return localDate2.toEpochDay() - localDate1.toEpochDay();
    }

    /** 字符串转日期
     * @param dateStr 日期串
     * @return
     */
    public static LocalDate str2LocalDate(String dateStr) {
        return LocalDate.parse(dateStr, FORMATTER_YYYY_MM_DD);
    }
}
