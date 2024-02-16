package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.repository.UserRepository;
import com.hexa.CareerPortal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository)
	{
		super();
		this.userRepository=userRepository;
	}
	
	@Override
	public User createUser(User user) {
		User savedUser=userRepository.save(user);
		return savedUser;
	}

	
	@Override
	public List<User> createUsers(List<User> user) {
		List<User> savedUsers=userRepository.saveAll(user);
		return savedUsers;
	}

	@Override
	public User updateName(Long id,String name) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			user.setName(name);
		}
		return user;
	}

	@Override
	public User updateEmail(Long id,String email) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			user.setEmail(email);
		}
		return user;
	}

	@Override
	public User changePassword(Long id,String password ) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			user.setPassword(password);
		}
		return user;
	}

	@Override
	public User findByName(String name) {
		User user=userRepository.findByName(name).orElse(null);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users=new ArrayList<>();
		users.addAll(userRepository.findAll());
		return users;
	}

	@Override
	public User findByUserId(Long id) {
		User user=userRepository.findByUserId(id).orElse(null);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user=userRepository.findByEmail(email).orElse(null);
		return user;	
		}

	@Override
	public List<User> findByRole(Role role) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByRole(role));
		return user;	
	}

	@Override
	public List<User> findByNameContaining(String name) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByNameContaining(name));
		return user;	
	}

	@Override
	public List<User> findByNameIn(List<String> names) {
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByNameIn(names));
		return user;
	}

	@Override
	public User deleteById(Long id) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
		userRepository.deleteById(id);
		}
		return user;
		
	}

	@Override
	public List<User> deleteAll() {
		List<User> users=new ArrayList<>();
		users.addAll(userRepository.findAll());
		if(users!=null)
		{
			userRepository.deleteAll();
		}
		return users;
	}
	@Override
	public long count() {
		Long count=userRepository.count();
		return count;
	}

	@Override
	public List<User> deleteAll(List<User> users) {
		List<User> user=new ArrayList<>();
		user.addAll(users);
		if(user!=null)
		{
			userRepository.deleteAll(users);
		}
		return user;
		
	}

}
