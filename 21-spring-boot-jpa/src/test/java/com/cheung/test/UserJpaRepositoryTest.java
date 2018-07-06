package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserJpaRepository;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试类
 *
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)// spring整合junit
@SpringBootTest(classes = {App.class})// 测试类加载启动类
public class UserJpaRepositoryTest {

	@Autowired
	private UserJpaRepository userJpaRepository;


	/**
	 * JpaRepository--测试1:新增
	 */
	@Test
	public void testJpaRepositorySave() {
		User user = new User("张三", 18, "北京市海淀区");
		User user2 = new User("李四", 20, "北京市顺义区");
		User user3 = new User("王五", 22, "北京市朝阳区");
		this.userJpaRepository.save(user);
		this.userJpaRepository.save(user2);
		this.userJpaRepository.save(user3);
	}

	/**
	 * JpaRepository--测试2:排序查询
	 */
	@Test
	public void testJpaRepositorySort() {
		// Order对象定义排序规则
		Sort.Order idOrder = new Sort.Order(Sort.Direction.DESC, "id");// id降序
		Sort.Order ageOrder = new Sort.Order(Sort.Direction.ASC, "age");// 年龄升序
		// Sort对象封装了排序规则
		Sort sort = new Sort(idOrder, ageOrder);

		/**
		 * 排序查询
		 */
		List<User> list = this.userJpaRepository.findAll(sort);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

}
