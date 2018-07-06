package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserRepositoryByName;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserRepositoryByNameTest {

	@Autowired
	private UserRepositoryByName userRepositoryByName;

	/**
	 * Repository--基于方法名称命名测试1
	 */
	@Test
	public void testFindByName() {
		List<User> list = this.userRepositoryByName.findByName("张三");
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * Repository--基于方法名称命名测试2
	 */
	@Test
	public void testFindByNameAndAge() {
		List<User> list = this.userRepositoryByName.findByNameAndAge("张三", 18);
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * Repository--基于方法名称命名测试3
	 */
	@Test
	public void testFindByNameOrAge() {
		List<User> list = this.userRepositoryByName.findByNameOrAge("张三", 20);
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * Repository--基于方法名称命名测试4
	 */
	@Test
	public void testFindByNameLike() {
		List<User> list = this.userRepositoryByName.findByNameLike("%张%");// 包含'张'
		// List<User> list = this.userRepositoryByName.findByNameLike("张%");// 以'张'开头(类似于findByNameStartingWith)
		// List<User> list = this.userRepositoryByName.findByNameLike("%张");// 以'张'开头(类似于findByNameEndingWith)
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * Repository--基于方法名称命名测试5
	 */
	@Test
	public void testFindByNameStartingWith() {
		List<User> list = this.userRepositoryByName.findByNameStartingWith("张");// 以'张'开头
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * Repository--基于方法名称命名测试6
	 */
	@Test
	public void testFindByNameEndingWith() {
		List<User> list = this.userRepositoryByName.findByNameEndingWith("张");// 以'张'结尾
		for (User user : list) {
			System.out.println(user);
		}
	}
}