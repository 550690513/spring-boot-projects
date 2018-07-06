package com.cheung.test;

import com.cheung.App;
import com.cheung.dao.UserJpaSpecificationExecutor;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserJpaSpecificationExecutorTest {

	@Autowired
	private UserJpaSpecificationExecutor userJpaSpecificationExecutor;

	/**
	 * JpaSpecificationExecutor--测试1:单条件查询
	 */
	@Test
	public void testJpaSpecificationExecutor1() {
		/**
		 * Specification<T>:用于封装查询条件
		 */
		Specification<User> specification = new Specification<User>() {
			/**
			 * Predicate:封装单个查询条件
			 *
			 * @param root 封装了查询对象的所有属性
			 * @param query 封装了所要执行的查询中的各部分信息,select from order by ...
			 * @param cb 查询条件构造器,用于定义不同的查询条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 例如:where name = '张三'

				/**
				 * 参数一:查询条件的属性(root封装了查询对象的所有属性,所以应该从root中取)
				 * 参数二:查询条件的值
				 */
				Predicate predicate = cb.equal(root.get("name"), "张三");
				return predicate;
			}
		};

		// 执行查询
		List<User> list = this.userJpaSpecificationExecutor.findAll(specification);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor--测试2:多条件查询 and
	 */
	@Test
	public void testJpaSpecificationExecutor2() {
		/**
		 * Specification<T>:用于封装查询条件
		 */
		Specification<User> specification = new Specification<User>() {
			/**
			 * Predicate:封装单个查询条件
			 *
			 * @param root 封装了查询对象的所有属性
			 * @param query 封装了所要执行的查询中的各部分信息,select from order by ...
			 * @param cb 查询条件构造器,用于定义不同的查询条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 例如:where name = '张三' and age = 18

				/*
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"), "张三"));// 第一个查询条件
				list.add(cb.equal(root.get("age"), 18));// 第二个查询条件

				Predicate[] arr = new Predicate[list.size()];
				Predicate predicate = cb.and(list.toArray(arr));// cb.and():两个查询条件之间的关系为"and"
				*/

				// 简单写法
				Predicate predicate = cb.and(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18));

				return predicate;
			}
		};

		// 执行查询
		List<User> list = this.userJpaSpecificationExecutor.findAll(specification);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor--测试3:多条件查询拓展 (and和or组合查询)
	 */
	@Test
	public void testJpaSpecificationExecutor3() {
		/**
		 * Specification<T>:用于封装查询条件
		 */
		Specification<User> specification = new Specification<User>() {
			/**
			 * Predicate:封装单个查询条件
			 *
			 * @param root 封装了查询对象的所有属性
			 * @param query 封装了所要执行的查询中的各部分信息,select from order by ...
			 * @param cb 查询条件构造器,用于定义不同的查询条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 例如:where name = '张三' and age = 18
				// Predicate predicate = cb.and(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18));

				// 例如:where name = '张三' or age = 18
				// Predicate predicate = cb.or(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18));

				// 例如:(where name = '张三' and age = 18) or address = "北京市朝阳区"
				Predicate predicate = cb.or(cb.and(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18)), cb.equal(root.get("address"), "北京市朝阳区"));

				return predicate;
			}
		};

		// 执行查询
		List<User> list = this.userJpaSpecificationExecutor.findAll(specification);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor--测试4:多条件查询拓展 (排序)
	 */
	@Test
	public void testJpaSpecificationExecutor4() {
		/**
		 * Specification<T>:用于封装查询条件
		 */
		Specification<User> specification = new Specification<User>() {
			/**
			 * Predicate:封装单个查询条件
			 *
			 * @param root 封装了查询对象的所有属性
			 * @param query 封装了所要执行的查询中的各部分信息,select from order by ...
			 * @param cb 查询条件构造器,用于定义不同的查询条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 例如:(where name = '张三' and age = 18) or address = "北京市朝阳区"
				Predicate predicate = cb.or(cb.and(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18)), cb.equal(root.get("address"), "北京市朝阳区"));

				return predicate;
			}
		};

		/**
		 * Sort排序对象
		 */
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));

		// 执行查询
		List<User> list = this.userJpaSpecificationExecutor.findAll(specification, sort);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	/**
	 * JpaSpecificationExecutor--测试5:多条件查询拓展 (排序 + 分页)
	 */
	@Test
	public void testJpaSpecificationExecutor5() {
		/**
		 * Specification<T>:用于封装查询条件
		 */
		Specification<User> specification = new Specification<User>() {
			/**
			 * Predicate:封装单个查询条件
			 *
			 * @param root 封装了查询对象的所有属性
			 * @param query 封装了所要执行的查询中的各部分信息,select from order by ...
			 * @param cb 查询条件构造器,用于定义不同的查询条件
			 * @return
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 例如:(where name = '张三' and age = 18) or address = "北京市朝阳区"
				Predicate predicate = cb.or(cb.and(cb.equal(root.get("name"), "张三"), cb.equal(root.get("age"), 18)), cb.equal(root.get("address"), "北京市朝阳区"));

				return predicate;
			}
		};

		/**
		 * Sort排序对象
		 */
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));

		/**
		 * Pageable分页对象
		 */
		Pageable pageable = new PageRequest(0, 2, sort);

		// 执行查询
		Page<User> page = this.userJpaSpecificationExecutor.findAll(specification, pageable);
		System.out.println("总条数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		List<User> list = page.getContent();
		for (User user : list) {
			System.out.println(user.toString());
		}

	}


}