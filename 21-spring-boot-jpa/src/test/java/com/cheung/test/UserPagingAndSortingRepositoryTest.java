package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserPagingAndSortingRepository;
import com.cheung.pojo.User;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserPagingAndSortingRepositoryTest {

	@Autowired
	private UserPagingAndSortingRepository userPagingAndSortingRepository;

	/**
	 * PagingAndSortingRepository--测试1:排序条件查询
	 */
	@Test
	public void testPagingAndSortingRepositorySort() {
		// Order对象定义排序规则
		Sort.Order idOrder = new Sort.Order(Sort.Direction.DESC, "id");// id降序
		Sort.Order ageOrder = new Sort.Order(Sort.Direction.ASC, "age");// 年龄升序
		// Sort对象封装了排序规则
		Sort sort = new Sort(idOrder, ageOrder);

		/**
		 * 排序查询
		 */
		List<User> list = (List<User>) this.userPagingAndSortingRepository.findAll(sort);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * PagingAndSortingRepository--测试2:分页查询
	 */
	@Test
	public void testPagingAndSortingRepositoryPage() {
		/**
		 * PageRequest(int page, int size)封装了分页的参数(当前页,每页条数),注意的是:当前页是从0开始
		 */
		Pageable pageable = new PageRequest(0, 2);// 第1页,每页2条
		/**
		 * 分页查询
		 */
		Page<User> page = this.userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总条数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		List<User> list = page.getContent();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * PagingAndSortingRepository--测试3:排序+分页
	 */
	@Test
	public void testPagingAndSortingRepository() {
		// Sort对象
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));
		// Pageable对象(带排序参数的)
		Pageable pageable = new PageRequest(0, 2, sort);
		// 排序+分页查询
		Page<User> page = this.userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总条数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		List<User> list = page.getContent();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}


}