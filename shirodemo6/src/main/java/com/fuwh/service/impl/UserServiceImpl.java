package com.fuwh.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuwh.dao.UserDao;
import com.fuwh.entity.User;
import com.fuwh.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	public Set<String> getRoles(String username) {
		// TODO Auto-generated method stub
		return userDao.getRoles(username);
	}

	public Set<String> getPermissions(Set<String> roles) {
		// TODO Auto-generated method stub
		return userDao.getPermissions(roles);
	}

	
}
