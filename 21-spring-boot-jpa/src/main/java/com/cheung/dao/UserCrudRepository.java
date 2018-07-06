package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 2.CrudRepository<T,ID>接口:该接口继承了Repository<T,ID>接口
 *
 * @author Cheung
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {


	// 需要注意的是:save()既是insert也是update(看源码)


}
