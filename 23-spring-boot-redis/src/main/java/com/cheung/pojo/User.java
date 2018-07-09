package com.cheung.pojo;

import java.io.Serializable;

/**
 * 用户 实体类
 *
 * @author Cheung
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8173961229317822066L;

	private Integer id;

	private String name;

	private Integer age;

	public User() {
	}

	public User(String name, Integer age, String address) {
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
