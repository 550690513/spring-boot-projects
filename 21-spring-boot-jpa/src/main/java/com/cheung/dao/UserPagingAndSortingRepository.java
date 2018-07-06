package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 3.PagingAndSortingRepository<T,ID>接口:该接口继承了CrudRepository<T,ID>接口
 *
 * @author Cheung
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {


}
