package com.cheung;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot启动类
 *
 * @author Cheung
 */
@SpringBootApplication
@MapperScan("com.cheung.mapper")// @MapperScan 用于扫描MyBatis的Mapper接口,根据扫描到的接口,生成对应的代理对象
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
