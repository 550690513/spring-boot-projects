package com.cheung.dao;

import com.cheung.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cheung
 */
public interface RoleJpaRepository extends JpaRepository<Role, Integer> {

}
