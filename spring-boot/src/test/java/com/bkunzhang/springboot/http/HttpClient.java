package com.bkunzhang.springboot.http;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/6/14
 */
public class HttpClient {

    public static HttpResponse httpGet(String url, Map<String, String> headers) {
        return HttpUtil.createGet(url)
                .addHeaders(headers)
                .cookie(headers.get("Cookie"))
                .timeout(5000)
                .execute();
    }

    public static HttpResponse httpPost(String url, Map<String, String> headers, String body) {
        return HttpUtil.createPost(url)
                .addHeaders(headers)
                .cookie(headers.get("Cookie"))
                .timeout(5000)
                .body(body)
                .execute();
    }

    public static void main(String[] args) {
        Map<String, String> mapHeaders = new HashMap<>();
        mapHeaders.put("1", "a");
        mapHeaders.put("2", "b");
        mapHeaders.put("authorization", "j2@j#jalahieruza");
//        HttpResponse httpResponse = httpGet("http://localhost:9999/getWeather?a=haha", mapHeaders);
//        System.out.println(httpResponse.toString());
        HttpResponse httpResponse2 = httpPost("http://localhost:9999/getWeather?a=haha", mapHeaders, "{\"a\": \"11\"}");
        System.out.println(httpResponse2.toString());
    }




}
