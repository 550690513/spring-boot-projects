package com.cheung.controller;

import com.cheung.pojo.User;
import com.cheung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Cheung
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 通用页面跳转方法
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String toPage(@PathVariable String page) {
		return page;
	}

	/**
	 * 用户列表页
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> list = this.userService.queryAll();
		model.addAttribute("list", list);
		return "list";
	}

	/**
	 * 添加用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(@NotNull User user) {
		this.userService.addUser(user);
		// return "ok";
		return "redirect:/user/list";
	}

	/**
	 * 根据id查询用户
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String findUserById(@NotNull Integer id, Model model) {
		User user = this.userService.findUserById(id);
		model.addAttribute("user", user);
		return "update";
	}

	/**
	 * 更新用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	public String editUser(@NotNull User user) {
		this.userService.updateUser(user);
		// return "ok";
		return "redirect:/user/list";
	}

	/**
	 * 根据id删除用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delUser")
	public String delUser(@NotNull Integer id) {
		this.userService.deleteUserById(id);
		// return "ok";
		return "redirect:/user/list";
	}


}
