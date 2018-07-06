package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserRepositoryByQueryAnnotation;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserRepositoryByQueryAnnotationTest {

	@Autowired
	private UserRepositoryByQueryAnnotation userRepositoryByQueryAnnotation;


	/**
	 * Repository--基于@Query注解测试1
	 */
	@Test
	public void testQueryByNameUseHQL() {
		List<User> list = this.userRepositoryByQueryAnnotation.queryByNameUseHQL("张三");
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * Repository--基于@Query注解测试2
	 */
	@Test
	public void testQueryByNameUseSQL() {
		List<User> list = this.userRepositoryByQueryAnnotation.queryByNameUseSQL("张三");
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * Repository--基于@Query注解测试2
	 */
	@Test
	@Transactional// 注意:当@Transactional和@Test注解一起使用时,事务是自动回滚的
	@Rollback(false)// 配置test取消回滚
	public void testUpdateUserNameById() {
		this.userRepositoryByQueryAnnotation.updateUserNameById("张三2", 1);
	}

}