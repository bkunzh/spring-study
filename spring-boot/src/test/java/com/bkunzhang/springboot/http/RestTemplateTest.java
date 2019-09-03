package com.bkunzhang.springboot.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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
            ResponseEntity responseEntity = restTemplate.exchange("http://localhost:9999/getJoke", HttpMethod.GET, null, String.class);
            System.out.println(responseEntity);
            System.out.println(responseEntity.getBody());
        }
    }
}
