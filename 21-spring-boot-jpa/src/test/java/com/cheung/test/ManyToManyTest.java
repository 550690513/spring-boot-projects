package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.RoleJpaRepository;
import com.cheung.pojo.Menu;
import com.cheung.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * 多对多 关联关系 测试
 *
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class ManyToManyTest {

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	/**
	 * 多对多 添加
	 */
	@Test
	public void testSave() {
		// 角色
		Role role = new Role("项目经理");
		// 菜单
		Menu menu = new Menu("***管理系统1", null, 0);
		Menu menu2 = new Menu("***管理系统2", null, 1);
		// 关联(双向关联)
		role.getMenuSet().add(menu);
		role.getMenuSet().add(menu2);
		menu.getRoleSet().add(role);
		menu2.getRoleSet().add(role);
		// 保存
		this.roleJpaRepository.save(role);
	}


	/**
	 * 多对多 查询
	 */
	@Test
	public void testFind() {
		Role role = this.roleJpaRepository.findOne(1);
		System.out.println(role.getRoleName());
		Set<Menu> menuSet = role.getMenuSet();
		for (Menu menu : menuSet) {
			System.out.println(menu.toString());
		}
	}

}
