package com.cheung.test;

import com.cheung.App;
import com.cheung.pojo.User;
import com.cheung.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;

	/**
	 * findUserById()方法未加缓存,控制台sql语句查询了2次
	 * findUserById()方法加@Cacheable注解开启缓存,控制台sql语句查询了1次
	 */
	@Test
	public void testFindUserById() {
		// 第一次查询
		System.out.println(this.userService.findUserById(1));
		// 第二次查询
		System.out.println(this.userService.findUserById(1));
	}

	/**
	 * 错误示例：（在test中演示）
	 * 此处若以“pageable对象的pageSize属性作为缓存的key”，
	 * 则只要pageable对象的pageSize值未发生变化时（key未改变），Ehcache都会默认该缓存存在，直接读取缓存来使用；
	 * 当且仅当pageabe对象的pageSize属性值发生变化时，Ehcache才会去重新查库。
	 */
	@Test
	public void testFindUserByPage() {
		Pageable pageable = new PageRequest(0, 10);
		// 第一次查询
		System.out.println(this.userService.findUserByPage(pageable).getContent().size());
		// 第二次查询
		System.out.println(this.userService.findUserByPage(pageable).getContent().size());

		// 第三次查询（此处pageable.pageSize值未改变，若findUserByPage(pageable)方法上@Cacheable()注解配置的key为#page.pageSize，则不会重新读库，直接使用上面的缓存数据，产生错误！！）
		pageable = new PageRequest(1, 10);
		System.out.println(this.userService.findUserByPage(pageable).getContent().size());

	}

	/**
	 * findUserAll()方法使用了缓存
	 * 1:若saveUser(user)方法未添加@CacheEvict做清空缓存的操作,则第二次查询结果错误!
	 * 2:saveUser(user)方法添加了@CacheEvict做清空缓存的操作,第二次查询则会重新查库,读取最新数据
	 */
	@Test
	public void testFindUserAll() {
		// 第一次查询
		System.out.println(this.userService.findUserAll().size());

		// 添加一条数据
		User user = new User("特朗普", 60, "纽约");
		this.userService.saveUser(user);

		// 第二次查询
		System.out.println(this.userService.findUserAll().size());

	}

	@Test
	public void testSaveUser() {
	}
}