//package com.hexa.CareerPortal.configuration;
//
//import org.springframework.context.annotation.Bean;
//
//import com.hexa.CareerPortal.entity.User;
//
//public class AuthenticationConfig {
//
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user = User.builder().username("Kunal").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN").build();
//		UserDetails user2 = User.builder().username("Sharma").password(bCryptPasswordEncoder().encode("123")).roles("USER").build();
//		return new InMemoryUserDetailsManager(user, user2);
//	}
//	
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}
//	
//	@Bean
//	AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//		var authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService);
//		authenticationProvider.setPasswordEncoder(passwordEncoder);
//		
//		return authenticationProvider;
//		
//	}
//	@Bean
//	PasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
