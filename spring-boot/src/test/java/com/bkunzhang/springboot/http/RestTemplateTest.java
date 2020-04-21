package com.bkunzhang.springboot.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bkunzhang on 2019/9/3.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void rest() {
        for (int i=0; i<5; ++i) {
            ResponseEntity responseEntity = restTemplate.exchange("http://localhost:9998/getJoke", HttpMethod.GET, null, String.class);
            System.out.println(responseEntity);
            System.out.println(responseEntity.getBody());
        }
    }

    @Test
    public void t() {
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        map.put("applyId", 37345);
        map.put("yearMonthStr", sdf.format(new Date()));
        map.put("restoreNum", 50);
//        Map<String, Object> rs = restTemplate.getForObject("http://localhost:8080/ommall/accbookexport/restoreAccBook", Map.class, map);

        Map<String, Object> rs = restTemplate.getForObject(getUrl("http://localhost:8080/ommall/accbookexport/restoreAccBook", map), Map.class);

//        String url = "http://localhost:8080/ommall/accbookexport/restoreAccBook?applyId=37345&yearMonthStr=" + sdf.format(new Date()) + "&restoreNum=50";
//        Map<String, Object> rs = restTemplate.getForObject(url, Map.class);
        System.out.println(rs);
    }

    static String getUrl(String url, Map<String, Object> params) {
        url += "?";
        for (String key : params.keySet()) {
            url += key + "=" + params.get(key) + "&";
        }
        url = url.substring(0, url.length() - 1);
        return url;
    }
}
