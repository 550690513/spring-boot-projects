package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot处理异常方式四：配置 SimpleMappingExceptionResolver 处理异常
 * <p>
 * 1.在全局异常类中添加一个方法完成异常的同一处理
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
