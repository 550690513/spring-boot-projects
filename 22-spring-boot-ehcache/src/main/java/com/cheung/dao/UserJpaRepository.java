package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 4.JpaRepository<T,ID>接口:(***开发中多用***)
 * <p>
 * (1).该接口继承了PagingAndSortingRepository<T,ID>接口
 * (2).对继承的父接口中的方法的返回值进行适配;
 *      例如: findAll() 返回值为List<T>而不是父接口的Iterator<T>    -->    不需要作强制类型转换了
 *
 * @author Cheung
 */
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
