package com.cheung.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * User实体类
 * <p>
 * SpringBoot 中使用了 Hibernate-validate 校验框架
 * 1.在实体类中添加校验规则
 * 2.在Controller中开启校验
 * <p>
 * <p>
 * 其他校验规则:
 *
 * @NotBlank: 判断字符串是否为 null 或者是空串(去掉首尾空格)。
 * @NotEmpty: 判断字符串是否 null 或者是空串。
 * @Length: 判断字符的长度(最大或者最小)
 * @Min: 判断数值最小值
 * @Max: 判断数值最大值
 * @Email: 判断邮箱是否合法
 */
public class User {

	@NotBlank(message = "用户名不能为空") // 非空校验
	@Length(min = 2, max = 6, message = "最小长度为2位，最大长度为6位")
	private String name;
	@NotEmpty
	private String password;
	@Min(value = 15)
	private Integer age;
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				'}';
	}
}
