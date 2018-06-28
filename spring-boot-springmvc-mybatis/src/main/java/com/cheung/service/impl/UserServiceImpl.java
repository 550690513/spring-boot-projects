package com.cheung.service.impl;

import com.cheung.mapper.UserMapper;
import com.cheung.pojo.User;
import com.cheung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Cheung
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> queryAll() {
		return this.userMapper.queryAll();
	}

	@Override
	public void addUser(User user) {
		this.userMapper.addUser(user);
	}

	@Override
	public User findUserById(Integer id) {
		return this.userMapper.findUserById(id);
	}

	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		this.userMapper.deleteUserById(id);
	}
}
