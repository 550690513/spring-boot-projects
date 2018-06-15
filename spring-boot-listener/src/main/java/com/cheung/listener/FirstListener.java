package com.cheung.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Spring Boot整合Listener 方式一: -->
 *      1.在Listener类上添加@WebListener注解扫描完成注册
 *      2.在启动类上添加@ServletComponentScan注解(Servlet组件扫描)
 *
 * 传统方式，在web.xml文件中配置
 *      <listener>
 *          <listener-class>com.cheung.listener.FirstListener</listener-class>
 *      </listener>
 *
 *
 * @author Cheung
 */
@WebListener
public class FirstListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("FirstListener init...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
