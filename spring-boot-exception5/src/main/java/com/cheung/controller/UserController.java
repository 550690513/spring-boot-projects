package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cheung
 */
@Controller
public class UserController {

	@RequestMapping("/showUser")
	public String showUser() {
		String str = null;
		str.length();
		return "index";
	}

	@RequestMapping("/showUsers")
	public String showUser2() {
		int a = 100 / 0;
		return "index";
	}
}
