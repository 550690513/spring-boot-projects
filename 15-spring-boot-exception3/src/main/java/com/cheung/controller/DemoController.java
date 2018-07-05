package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot处理异常方式三：@ControllerAdvice+@ExceptionHandler 注解处理异常
 *
 * 1.需要创建一个能够处理异常的全局异常类,在该类上需添加@ControllerAdvice 注解。
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
