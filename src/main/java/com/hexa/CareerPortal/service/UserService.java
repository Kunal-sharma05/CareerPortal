package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;

public interface UserService {
	public User createUser(User user);
	public List<User> createUsers(List<User> user);
	public User findByName(String name);
	public List<User> findAll();

	public User findByUserId(Long id);
	public User findByEmail(String email);
	public List<User> findByRole(Role role);
	public List<User> findByNameContaining(String name);
	public List<User> findByNameIn(List<String> names);
	public User deleteById(Long id);
	public List<User> deleteAll();
	public long count();
	public List<User> deleteAll(List<User> user);
	public User updateName(Long id,String name);
	public User updateEmail(Long id,String Email);
	public User changePassword(Long id,String password);
}
