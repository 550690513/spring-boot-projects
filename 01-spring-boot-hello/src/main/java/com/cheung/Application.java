package com.cheung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot启动类
 *
 * 注意事项:
 * 1.启动类存放位置:可以和controller位于同一包下,或者位于controller的上级包下;不能放到controller平级包下或者controller的子包下.
 *
 * @author Cheung
 */
// Spring Boot启动类的注解
@SpringBootApplication
public class Application {

	// Spring Boot启动类执行方法入口
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
