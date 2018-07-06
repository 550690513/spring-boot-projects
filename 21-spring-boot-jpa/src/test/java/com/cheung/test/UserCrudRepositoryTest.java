package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserCrudRepository;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserCrudRepositoryTest {

	@Autowired
	private UserCrudRepository userCrudRepository;

	/**
	 * CrudRepository--测试1:新增与更新
	 */
	@Test
	public void testCrudRepositorySave() {
		// 需要注意的是:save()既是insert也是update(看源码)

		User user = new User("小芳", 18, "天津");
		/**
		 * 1.测试insert
		 */
		this.userCrudRepository.save(user);

		/**
		 * 2.测试update
		 */
		user.setId(4);// 此id为上面新插入的那条数据的id
		user.setName("小芳2");
		user.setAge(19);
		user.setAddress("南京");
		this.userCrudRepository.save(user);
	}

	/**
	 * CrudRepository--测试2:查询一个
	 */
	@Test
	public void testCrudRepositoryFindOne() {
		User user = this.userCrudRepository.findOne(4);
		System.out.println(user.toString());
	}

	/**
	 * CrudRepository--测试3:查询所有
	 */
	@Test
	public void testCrudRepositoryFindAll() {
		List<User> list = (List<User>) this.userCrudRepository.findAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * CrudRepository--测试4:根据id删除
	 */
	@Test
	public void testCrudRepositoryDeleteById() {
		this.userCrudRepository.delete(4);
	}


}