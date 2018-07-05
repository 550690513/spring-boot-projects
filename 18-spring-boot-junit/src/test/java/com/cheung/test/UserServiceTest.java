package com.cheung.test;

import com.cheung.App;
import com.cheung.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringBoot测试类
 *
 * @RunWith:启动器
 *      SpringJUnit4ClassRunner.class：让junit与spring环境进行整合
 * @SpringBootTest(classes={App.class})
 *      1, 当前类为springBoot的测试类
 *      2, 让当前类去加载SpringBoot启动类,启动springBoot
 *      [类似于原始项目:junit与spring整合 @ContextConfiguration("classpath:applicationContext.xml"),配置测试类启动时,加载spring配置文件的路径]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Test
	public void testAddUser() {
		this.userServiceImpl.addUser();
	}
}
