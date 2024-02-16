package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;

public interface UserService {
	public User createUser(User user);
	public UserDTO createUser(UserDTO user);
	public User findByName(String name);
	public List<UserDTO> findAll();

	public UserDTO findByUserId(Long id);
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
	public List<UserDTO> createUsers(List<UserDTO> user);
	public UserDTO updateUser(Long userId, UserDTO userDTO);
}
