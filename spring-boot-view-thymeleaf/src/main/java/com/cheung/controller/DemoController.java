package com.cheung.controller;

import com.cheung.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Thymeleaf入门案例
 * <p>
 * Thymeleaf也是模板型的视图层技术
 * 1.创建存放视图的目录,目录位置：src/main/resources/templates
 * 2.templates：该目录是安全的。意味着该目录下的内容是不允许外界直接访问的。
 *
 * @author Cheung
 */
@Controller
public class DemoController {

	@RequestMapping("/show")
	public String showInfo(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "Thymeleaf 第一个案例");
		model.addAttribute("key", new Date());
		return "index";
	}

	@RequestMapping("/show2")
	public String showInfo2(Model model) {
		model.addAttribute("sex", "女");
		model.addAttribute("id", "1");
		return "index2";
	}

	@RequestMapping("/show3")
	public String showInfo3(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "张三", 20));
		list.add(new User(2, "李四", 22));
		list.add(new User(3, "王五", 24));
		model.addAttribute("list", list);
		return "index3";
	}

	@RequestMapping("/show4")
	public String showInfo4(Model model) {
		Map<String, User> map = new HashMap<>();
		map.put("u1", new User(1, "张三", 20));
		map.put("u2", new User(2, "李四", 22));
		map.put("u3", new User(3, "王五", 24));
		model.addAttribute("map", map);
		return "index4";
	}

	/**
	 * 域对象中存值,取值
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/show5")
	public String showInfo5(HttpServletRequest request, Model model) {
		// 存入HttpServletRequest域对象
		request.setAttribute("req", "HttpServletRequestInfo_my");
		// 存入HttpSession域对象
		HttpSession session = request.getSession();
		session.setAttribute("sess", "HttpSessionInfo_my");
		// 存入ServletContext域对象
		ServletContext servletContext = request.getSession().getServletContext();
		servletContext.setAttribute("app", "ServletContextInfo_my");
		return "index5";
	}

}
