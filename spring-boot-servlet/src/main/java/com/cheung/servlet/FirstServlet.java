package com.cheung.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Boot整合Servlet 方式一: -->
 *      1.在Servlet类上添加@WebServlet(name = "", urlPatterns = "")注解扫描完成注册
 *      2.在启动类上添加@ServletComponentScan注解(Servlet组件扫描)
 *
 * 传统方式:
 *      web.xml文件配置
 *      <servlet>
 *          <servlet-name>FirstServlet</servlet-name>
 *          <servlet-class>com.cheung.servlet.FirstServlet</servlet-class>
 *      </servlet>
 *      <servlet-mapping>
 *          <servlet-name>FirstServlet</servlet-name>
 *          <url-pattern>/first</url-pattern>
 *      </servlet-mapping>
 *
 * @author Cheung
 */
@WebServlet(name = "FirstServlet", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FirstServlet..........");
	}

}
