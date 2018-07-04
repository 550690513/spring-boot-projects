package com.cheung.service;

import com.cheung.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cheung
 */
@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl userDaoImpl;

	public void addUser() {
		this.userDaoImpl.saveUser();
	}
}
