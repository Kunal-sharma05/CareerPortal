package com.hexa.CareerPortal.service;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.serviceImpl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	public static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	UserServiceImpl productServiceImpl;
	
	
	public void createUserMethodTest()
	{
		
	}
}
