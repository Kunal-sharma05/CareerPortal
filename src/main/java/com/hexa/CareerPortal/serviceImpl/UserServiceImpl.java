package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.repository.EmployerRepository;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.repository.UserRepository;
import com.hexa.CareerPortal.service.UserService;

import ch.qos.logback.classic.Level;

@Service
public class UserServiceImpl implements UserService {
	
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private ModelMapper modelMapper;
	
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
    private EmployerRepository employerRepository;
    
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
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
		List<User> users=user.stream().map(userDTO->modelMapper.map(userDTO,User.class)).collect(Collectors.toList());
		List<User> savedUsers=userRepository.saveAll(users);
		user=savedUsers.stream().map(User->modelMapper.map(savedUsers, UserDTO.class)).collect(Collectors.toList());
		return user;
	}

	@Override
	public UserDTO updateName(Long id,String name) {
		User user=userRepository.findById(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
			user.setName(name);
			userRepository.save(user);
			userDTO=modelMapper.map(user,UserDTO.class );
		}
		return userDTO;
	}

	@Override
	public UserDTO updateEmail(Long id,String email) {
		User user=userRepository.findById(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
			user.setEmail(email);
			userRepository.save(user);
			userDTO=modelMapper.map(user,UserDTO.class );
		}
		return userDTO;
	}

	@Override
	public User changePassword(Long id,String password ) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			user.setPassword(password);
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public List<UserDTO> findByName(String name) {
		List<User> user=userRepository.findByName(name).orElse(null);
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;
	}

	@Override
	public List<UserDTO> findAll() {
	    List<User> users = userRepository.findAll();
	    List<UserDTO> userDTOs = users.stream()
	                                  .map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	    System.out.println(""+ userDTOs.toString());
	    return userDTOs;
	}

	@Override
	public UserDTO findByUserId(Long id) {
		User user=userRepository.findByUserId(id).orElse(null);
		UserDTO userDTO=null;
		if(user!=null)
		{
		userDTO=modelMapper.map(user, UserDTO.class);
		}
		return userDTO;
	}

	@Override
	public UserDTO findByEmail(String email) {
		User user=userRepository.findByEmail(email).orElse(null);
		UserDTO userDTO=modelMapper.map(user, UserDTO.class);
		return userDTO;
		}

	@Override
	public List<UserDTO> findByRole(Role role) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByRole(role));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;	
	}

	@Override
	public List<UserDTO> findByNameContaining(String name) 
	{
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByNameContaining(name));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;		
	}

	@Override
	public List<UserDTO> findByNameIn(List<String> names) {
		List<User> user=new ArrayList<>();
		user.addAll(userRepository.findByNameIn(names));
		List<UserDTO> users=user.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return users;
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
	public List<UserDTO> deleteAll() {
		List<User> users=new ArrayList<>();
		users.addAll(userRepository.findAll());
		if(users!=null)
		{
			userRepository.deleteAll();
		}
		List<UserDTO> userDTOs=users.stream().map(User->modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());
		return userDTOs;
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
			user.setPassword(userDTO.getPassword());
			user.setRole(userDTO.getRole());
			userRepository.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}
	@Override
	public UserDTO addEmployer(Long userId, EmployerDTO employerDto) {
		User user=userRepository.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
			Employer employerEntity=modelMapper.map(employerDto, Employer.class);
			Employer employer1=employerRepository.save(employerEntity);
			employerDto=modelMapper.map(employer1,EmployerDTO.class);
			user.setEmployer(employer1);
			userRepository.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}
	@Override
	public UserDTO addJobSeeker(Long userId, JobSeekerDTO jobSeekerDto) {
		User user=userRepository.findById(userId).orElse(null);
		UserDTO user1=null;
		if(user!=null)
		{
		
			JobSeeker JobSeekerEntity=  modelMapper.map(jobSeekerDto, JobSeeker.class);
			JobSeeker savedJobSeeker= jobSeekerRepository.save(JobSeekerEntity);
			jobSeekerDto=modelMapper.map(savedJobSeeker,JobSeekerDTO.class );
			user.setJobSeeker(savedJobSeeker);
			userRepository.save(user);
			user1=modelMapper.map(user,UserDTO.class);
		}
		
		return user1;
	}

}
