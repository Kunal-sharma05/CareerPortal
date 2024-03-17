package com.hexa.CareerPortal.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.JWTAuthResponse;
import com.hexa.CareerPortal.dto.LoginDto;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.service.AuthService;
 
@RestController
@RequestMapping("/api/authenticate")
@CrossOrigin("http://localhost:3000")
public class AuthController {
	private AuthService authService;
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	@PostMapping(value = {"/login","/signin"})
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto dto)
	{
		JWTAuthResponse token = authService.login(dto);
		/*JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);*/
		return ResponseEntity.ok(token);
	}
 
	@PostMapping(value = {"/register","/signup"})
	public ResponseEntity<String> register(@RequestBody UserDTO dto)
	{
		String value = authService.register(dto);
		return new ResponseEntity<>(value, HttpStatus.CREATED);
	}
}