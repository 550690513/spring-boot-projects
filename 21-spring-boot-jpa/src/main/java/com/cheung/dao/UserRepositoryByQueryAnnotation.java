package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 1.2Repository<T,ID>接口基于@Query注解查询与更新
 *
 * @author Cheung
 */
public interface UserRepositoryByQueryAnnotation extends Repository<User, Integer> {

	/**
	 * @Query注解默认使用HQL语句,hibernate会对hql语句做转换处理(nativeQuery = false)
	 */
	@Query(value = "from User where name = ?")
	List<User> queryByNameUseHQL(String name);


	/**
	 * 配置使用原生SQL语句,hibernate不做转换处理(nativeQuery = true)
	 */
	@Query(value = "select * from user_jpa where name = ?", nativeQuery = true)
	List<User> queryByNameUseSQL(String name);


	/**
	 * 1、在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。
	 * 2、UPDATE或者DELETE操作需要使用事务，此时需要 定义Service层，在Service层的方法上添加事务操作。
	 * 3、注意JPQL不支持INSERT操作。
	 */
	@Query(value = "update User set name = ? where id = ?")
	@Modifying
	void updateUserNameById(String name, Integer id);


}
