package com.bkunzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringbootDownloadApplication {

	public static void main(String[] args) {
		System.out.println("开始启动");
		SpringApplication.run(SpringbootDownloadApplication.class, args);
		System.out.println("启动完成");
	}
}
