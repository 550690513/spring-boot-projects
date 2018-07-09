package com.cheung.service;

import com.cheung.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author Cheung
 */
public interface UserService {

	User findUserById(Integer id);

	Page<User> findUserByPage(Pageable pageable);

	List<User> findUserAll();

	void saveUser(User user);

}
