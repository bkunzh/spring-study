package com.bkunzhang.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by bkunzhang on 2019/6/1.
 */
@Data
@AllArgsConstructor
public class RequestAndResponse {
    private Object request;
    private Object response;
}
