package com.cheung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot 启动类
 *
 * @author Cheung
 */
@SpringBootApplication
@EnableScheduling// 在启动类中开启Scheduled
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
