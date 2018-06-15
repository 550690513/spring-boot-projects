package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheung
 */
@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> showHelloWorld() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", "Hello World");
		return map;
	}

}
