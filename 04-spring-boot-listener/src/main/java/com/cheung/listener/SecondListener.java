package com.cheung.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Spring Boot整合Listener 方式二: --> 在启动类中,用方法完成Listener的注册
 *
 * @author Cheung
 */
public class SecondListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("SecondListener init...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
