package com.fuwh.dao;

import java.util.Set;

import com.fuwh.entity.User;

public interface UserDao {

	public User getUser(User user);
	
	public Set<String> getRoles(String username);
	
	public Set<String> getPermissions(Set<String> roles);
	
}
