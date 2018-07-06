package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 1.1Repository<T,ID>接口基于方法名称命名查询
 * <p>
 *      参数一 T :当前需要映射的实体
 *      参数二 ID :当前映射的实体中的OID(主键)的类型
 * </p>
 * <p>
 * SpringData JPA 提供的核心接口(接下来逐个讲解)
 *      1.Repository<T,ID>接口:
 *           1.1提供了方法名称命名查询方式
 *           1.2提供了基于@Query注解查询与更新
 *      2.CrudRepository<T,ID>接口:
 *      3.PagingAndSortingRepository<T,ID>接口:
 *      4.JpaRepository<T,ID>接口:
 *      5.JpaSpecificationExecutor<T>接口:
 * </p>
 *
 * @author Cheung
 */
public interface UserRepositoryByName extends Repository<User, Integer> {

	/**
	 * 方法名称命名规则
	 * 1.必须遵循驼峰式
	 * 2.findBy(关键字:表示查询)+属性名称(首字母大写)+查询条件(首字母大写)
	 */
	List<User> findByName(String name);

	List<User> findByNameAndAge(String name, Integer age);

	List<User> findByNameOrAge(String name, Integer age);

	List<User> findByNameLike(String name);

	List<User> findByNameStartingWith(String name);

	List<User> findByNameEndingWith(String name);

}
