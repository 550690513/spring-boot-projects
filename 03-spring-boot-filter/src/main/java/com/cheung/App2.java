package com.cheung;

import com.cheung.filter.SecondFilter;
import com.cheung.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot整合Filter 方式二: --> 在启动类中,用方法完成Filter的注册
 *
 * @author Cheung
 */
@SpringBootApplication
public class App2 {

	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}

	/**
	 * 注册Servlet
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}


	/**
	 * 注册Filter
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		// bean.addUrlPatterns(new String[]{"*.do", "*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}


}
