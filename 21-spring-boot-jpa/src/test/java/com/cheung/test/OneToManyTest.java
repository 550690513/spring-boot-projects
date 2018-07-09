package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserJpaRepository;
import com.cheung.pojo.Role;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 一对多 关联关系 测试
 *
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class OneToManyTest {

	@Autowired
	private UserJpaRepository userJpaRepository;

	/**
	 * 一对多 添加
	 */
	@Test
	public void testSave() {
		// 用户
		User user = new User("小刚", 19, "台湾省");
		// 角色
		Role role = new Role("管理员");
		// 关联(一定是双向关系)
		user.setRole(role);
		role.getUserSet().add(user);
		// 保存
		this.userJpaRepository.save(user);
	}

	/**
	 * 一对多 查询
	 */
	@Test
	public void testFind() {
		User user = this.userJpaRepository.findOne(4);
		System.out.println(user);
		System.out.println(user.getRole().getRoleName());
	}


}
