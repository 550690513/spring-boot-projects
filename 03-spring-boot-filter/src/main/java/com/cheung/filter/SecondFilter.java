package com.cheung.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Spring Boot整合Filter 方式二: --> 在启动类中,用方法完成Filter的注册
 *
 *
 * @author Cheung
 */
public class SecondFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("进入SecondFilter...");
		filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("离开SecondFilter...");
	}

	@Override
	public void destroy() {

	}
}
