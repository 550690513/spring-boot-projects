package com.cheung.dao;

import com.cheung.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 5.JpaSpecificationExecutor<T>接口:
 * <p>
 * (1).该接口主要提供了对"多条件查询"的支持,并且可以在查询中添加分页和排序
 * (2).该接口单独存在,和前四个接口无关
 * (3).开发中,一般和JpaRepository<T,ID>接口组合使用
 *
 * @author Cheung
 */
public interface UserJpaSpecificationExecutor extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer> {




}
