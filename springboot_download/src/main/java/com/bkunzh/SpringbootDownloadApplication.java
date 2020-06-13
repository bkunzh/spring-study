package com.bkunzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringbootDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDownloadApplication.class, args);
	}
}
