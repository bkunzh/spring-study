package com.bkunzhang.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by bkunzhang on 2019/6/1.
 */
@Data
@AllArgsConstructor
public class Weather {
    private Date date;
    private String weather;
    private double temperature;
}
