package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.repository.UserRepository;
import com.hexa.CareerPortal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
    @Autowired
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
	public UserDTO createUser(UserDTO user) {
		User userEntity=modelMapper.map(user, User.class);
		User savedUser=userRepository.save(userEntity);
		user=modelMapper.map(savedUser,UserDTO.class );
		return user;
	}

	@Override
	public List<UserDTO> createUsers(List<UserDTO> user) {
		List<User> users=user.stream().map(userDTO->modelMapper.map(userDTO,User.class)).toList();
		List<User> savedUsers=userRepository.saveAll(users);
		user=savedUsers.stream().map(User->modelMapper.map(savedUsers, UserDTO.class)).toList();
		return user;
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
	public List<UserDTO> findAll() {
		List<User> users=new ArrayList<>();
		users.addAll(userRepository.findAll());
		List<UserDTO> user=users.stream().map(User->modelMapper.map(users, UserDTO.class)).toList();
		return user;
	}

	@Override
	public UserDTO findByUserId(Long id) {
		User user=userRepository.findByUserId(id).orElse(null);
		UserDTO userDTO=modelMapper.map(user, UserDTO.class);
		return userDTO;
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

	@Override
	public UserDTO updateUser(Long userId, UserDTO userDTO) {
		User user=userRepository.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
			user.setEmail(userDTO.getEmail());
			user.setName(userDTO.getName());
			user.setPassword(user.getPassword());
			user.setRole(user.getRole());
			userRepository.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}

}
