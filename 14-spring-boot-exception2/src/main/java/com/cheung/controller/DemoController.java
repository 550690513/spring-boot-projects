package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot处理异常方式二：@ExceptionHandle 注解处理异常
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


	/**
	 * java.lang.NullPointerException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value = {NullPointerException.class})
	public ModelAndView nullPointerExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error1");
		return mv;
	}


	/**
	 * java.lang.ArithmeticException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value = {ArithmeticException.class})
	public ModelAndView arithmeticExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error2");
		return mv;
	}

}
