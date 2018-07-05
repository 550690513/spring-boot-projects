package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot处理异常方式一：自定义错误页面
 * <p>
 * SpringBoot 默认的处理异常的机制：SpringBoot 默认的已经提供了一套处理异常的机制。
 * 一旦程序中出现了异常 SpringBoot 会向/error 的 url 发送请求。
 * 在 springBoot 中提供了一个叫 BasicExceptionController 来处理/error 请求，然后跳转到默认显示异常的页面来展示异常信息。
 * <p>
 * 如果我们需要将所有的异常同一跳转到自定义的错误页面，需要在src/main/resources/templates 目录下创建 error.html 页面。注意：名称必须叫 error
 *
 * @author Cheung
 */
@Controller
public class DemoController {

	@RequestMapping("/show")
	public String showInfo() {
		String str = null;
		str.length();// 模拟空指针异常
		return "index";
	}

	@RequestMapping("/show2")
	public String showInfo2() {
		int a = 10 / 0;// 模拟算术异常(除数不能为0)
		return "index";
	}


}
