package com.cheung.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Spring Boot整合Filter 方式一: -->
 *      1.在Filter类上添加@WebFilter(filterName = "", urlPatterns = "")注解扫描完成注册
 *      2.在启动类上添加@ServletComponentScan注解(Servlet组件扫描)
 *
 * 传统方式，在web.xml文件中配置
 *      <filter>
 *          <filter-name>FirstFilter</filter-name>
 *          <filter-class>com.cheung.filter.FirstFilter</filter-class>
 *      </filter>
 *      <filter-mapping>
 *          <filter-name>FirstFilter</filter-name>
 *          <url-pattern>/first</url-pattern>
 *      </filter-mapping>
 *
 * @author Cheung
 */
// @WebFilter(filterName = "FirstFilter", urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("进入FirstFilter...");
		filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("离开FirstFilter...");
	}

	@Override
	public void destroy() {

	}

}
