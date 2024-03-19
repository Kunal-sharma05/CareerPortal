package com.hexa.CareerPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.security.JwtAuthenticationEntryPoint;
import com.hexa.CareerPortal.security.JwtAuthenticationFilter;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	private UserDetailsService userDetailsService;
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	public SecurityConfig(UserDetailsService userDetailsService,
							JwtAuthenticationEntryPoint authenticationEntryPoint,
							JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.userDetailsService = userDetailsService;
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	@Bean
	public static PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf().disable()
			.authorizeHttpRequests((authorize) ->
			//authorize.anyRequest().authenticated()
			authorize.requestMatchers("/api/authenticate/**").permitAll()
			.requestMatchers("/api/employers/**").hasAuthority(Role.EMPLOYER.name()) 
			.requestMatchers("/api/employers/**").hasAuthority(Role.ADMIN.name())//,
			.requestMatchers(HttpMethod.POST, "/api/jobListings/**").hasAuthority(Role.EMPLOYER.name())
			.requestMatchers("/api/**").permitAll()
			.anyRequest().authenticated())
			.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
 
}