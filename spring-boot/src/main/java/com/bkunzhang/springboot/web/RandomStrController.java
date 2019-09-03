package com.bkunzhang.springboot.web;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by bkunzhang on 2019/7/12.
 * 返回随机笑话
 */
@RestController
public class RandomStrController {

    static Logger log = LoggerFactory.getLogger(RandomStrController.class);

    static List<String> jokes;
    static {
        try {
            jokes = IOUtils.readLines(RandomStrController.class.getClassLoader().getResourceAsStream("joke.txt"), "utf-8");
        } catch (IOException e) {
            log.error("IOUtils.readLines error", e);
        }
    }


    @RequestMapping("/getJoke")
    public String getJoke() {
        if (jokes == null || jokes.isEmpty()) {
            return "没有笑话";
        }
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }

    public static void main(String[] args) {
        IntStream.iterate(0, n -> n+1).limit(10).forEach(n -> System.out.println(new RandomStrController().getJoke()));
    }
}
