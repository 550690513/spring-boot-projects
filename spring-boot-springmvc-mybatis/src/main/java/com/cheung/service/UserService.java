package com.cheung.service;

import com.cheung.pojo.User;

import java.util.List;

/**
 * @author Cheung
 */
public interface UserService {

	List<User> queryAll();

	void addUser(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);
}
