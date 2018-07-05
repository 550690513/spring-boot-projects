package com.cheung.mapper;

import com.cheung.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Cheung
 */
@Component
public interface UserMapper {

	List<User> queryAll();

	void addUser(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);

}
