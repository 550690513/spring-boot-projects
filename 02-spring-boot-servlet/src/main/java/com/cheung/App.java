package com.cheung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring Boot整合Servlet 方式一: -->
 *      1.在Servlet类上添加@WebServlet(name = "", urlPatterns = "")注解扫描完成注册
 *      2.在启动类上添加@ServletComponentScan注解(Servlet组件扫描)
 *
 * @author Cheung
 */
@SpringBootApplication
@ServletComponentScan// 在Spring Boot启动时,会扫描用@WebServlet注解的类,并实例化该类
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
