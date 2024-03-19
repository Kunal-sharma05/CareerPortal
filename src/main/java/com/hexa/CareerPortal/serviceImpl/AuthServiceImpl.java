package com.hexa.CareerPortal.serviceImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.JWTAuthResponse;
import com.hexa.CareerPortal.dto.LoginDto;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.exception.BadRequestException;
import com.hexa.CareerPortal.repository.UserRepository;
import com.hexa.CareerPortal.security.JwtTokenProvider;
import com.hexa.CareerPortal.service.AuthService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
	private AuthenticationManager authenticationManager;
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, 
			UserRepository userRepo,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	@Override
	public JWTAuthResponse login(LoginDto dto) {
		System.out.println(("object received"+dto));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		System.out.println(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		System.out.println("Token generated : "+token);
		User user = userRepo.findByEmail(dto.getEmail()).get();
		System.out.println("user object found in repo "+user);
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
//		userDto.setUserId(user.getUserId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
		Role role=Role.JOB_SEEKER;
		Role roleUser = user.getRole();
			if(roleUser.name().equalsIgnoreCase("ADMIN"))
				role = Role.ADMIN;
			else
				if(roleUser.name().equalsIgnoreCase("EMPLOYER"))
					role = Role.EMPLOYER;
		userDto.setRole(role);
		return new JWTAuthResponse(token,userDto);
	}
	@Override
	public String register(UserDTO dto) {
		if((userRepo.findByEmail(dto.getEmail())).orElse(null)!=null)
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exist");
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		
		userRepo.save(user);
		return "Register Successfull!..";
	}

}