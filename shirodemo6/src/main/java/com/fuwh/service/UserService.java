package com.fuwh.service;

import java.util.Set;

import com.fuwh.entity.User;

public interface UserService {

	public User getUser(User user);

	public Set<String> getRoles(String username);

	public Set<String> getPermissions(Set<String> roles);
}
