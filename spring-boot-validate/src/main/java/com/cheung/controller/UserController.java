package com.cheung.controller;

import com.cheung.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * SpringBoot 表单数据校验
 * <p>
 * SpringBoot 中使用了 Hibernate-validate 校验框架
 * 1.在实体类中添加校验规则
 * 2.在Controller中开启校验
 *
 * @author Cheung
 */
@Controller
public class UserController {

	/**
	 * 解决异常的方式:可以在跳转页面的方法中注入一个 Uesr 对象。
	 * 注意：由于 springmvc 会将该对象放入到 Model 中传递。
	 * key 的名称会使用该对象的驼峰式的命名规则来作为 key。
	 * 参数的变量名需要与对象的名称相同。将首字母小写。
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String showPage(User user) {
		return "add";
	}

	/**
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")
	 * 这表示当前传递的对象的 key 为 aa。
	 * 那么我们在页面中获取该对象的 key 也需要修改为 aa
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser2")
	public String showPage2(@ModelAttribute("aa") User user) {
		return "add2";
	}


	/**
	 * 完成用户添加
	 *
	 * @Valid 开启对User对象的数据校验
	 * BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save")
	public String saveUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		}
		System.out.println(user);
		return "ok";
	}

	/**
	 * 完成用户添加
	 *
	 * @Valid 开启对 Users 对象的数据校验
	 * BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save2")
	public String saveUser2(@ModelAttribute("aa") @Valid User users, BindingResult result) {
		if (result.hasErrors()) {
			return "add2";
		}
		System.out.println(users);
		return "ok";
	}
}
