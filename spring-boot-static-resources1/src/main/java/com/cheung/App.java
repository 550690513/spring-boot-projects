package com.cheung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot启动类
 *
 * SpringBoot访问静态资源 方式一: --> 在classpath/static目录下访问(注意名称必须为static)
 * 即:resources/static/...
 *
 *
 * @author Cheung
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
