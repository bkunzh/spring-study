package com.bkunzhang.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by bkunzhang on 2019/6/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
    private Map<String, Object> headers;
    private Object bodys;
}
