package com.hexa.CareerPortal.service;

import com.hexa.CareerPortal.dto.JWTAuthResponse;
import com.hexa.CareerPortal.dto.LoginDto;
import com.hexa.CareerPortal.dto.UserDTO;

public interface AuthService {
	JWTAuthResponse login(LoginDto dto);
	String register(UserDTO dto);
}