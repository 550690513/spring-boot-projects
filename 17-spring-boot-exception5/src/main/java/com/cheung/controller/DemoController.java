package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot处理异常方式五：自定义 HandlerExceptionResolver 类处理异常
 * <p>
 * 1.需要在全局异常处理类中实现 HandlerExceptionResolver 接口
 *
 * @author Cheung
 */
@Controller
public class DemoController {

	@RequestMapping("/show")
	public String showInfo() {
		String str = null;
		str.length();
		return "index";
	}

	@RequestMapping("/show2")
	public String showInfo2() {
		int a = 10 / 0;
		return "index";
	}


}
