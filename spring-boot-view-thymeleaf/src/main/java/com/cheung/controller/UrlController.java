package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Thymeleaf-url表达式
 *
 * @author Cheung
 */
@Controller
@RequestMapping("/url")
public class UrlController {

	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page, Integer id, String name, Model model) {
		System.out.println(id + "---" + name);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "url/" + page;
	}

}
