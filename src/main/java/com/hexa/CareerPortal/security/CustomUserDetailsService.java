package com.hexa.CareerPortal.security;
import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	// Constructor DI
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Email"));
		Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
		return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), authorities);
	}
}