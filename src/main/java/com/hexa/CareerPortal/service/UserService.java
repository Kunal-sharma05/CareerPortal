package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;

public interface UserService {
	public User createUser(User user);
	public UserDTO createUser(UserDTO user);
	public List<UserDTO> findByName(String name);
	public List<UserDTO> findAll();

	public UserDTO findByUserId(Long id);
	public UserDTO findByEmail(String email);
	public List<UserDTO> findByRole(Role role);
	public List<UserDTO> findByNameContaining(String name);
	public List<UserDTO> findByNameIn(List<String> names);
	public User deleteById(Long id);
	public List<UserDTO> deleteAll();
	public long count();
	public List<User> deleteAll(List<User> user);
	public UserDTO updateName(Long id,String name);
	public UserDTO updateEmail(Long id,String Email);
	public User changePassword(Long id,String password);
	public List<UserDTO> createUsers(List<UserDTO> user);
	public UserDTO updateUser(Long userId, UserDTO userDTO);
	UserDTO addEmployer(Long userId, EmployerDTO employerDto);
	UserDTO addJobSeeker(Long userId, JobSeekerDTO jobSeekerDto);
}
