package com.hexa.CareerPortal.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.serviceImpl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	
	//public static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Test
	public void createUserMethodTest()
	{
	//	UserDTO userDTO = new UserDTO(
		//	    "John Doe", 
			//    "johndoe@example.com", 
			  //  "Password123!", 
			    //Role.EMPLOYER, 
			    //new EmployerDTO("John Doe", "Company Name", "1234567890", "company@example.com", new ArrayList<>()), 
		//	    new JobSeekerDTO("John Doe", "Professional details", "Education details", "9876543210", new java.util.Date(), "jobseeker@example.com", new ArrayList<>())
		//	);
		//LOGGER.log(Level.INFO, "User in db using JPA save()"+userDTO);
		//UserDTO user=userServiceImpl.createUser(userDTO);
		//LOGGER.log(Level.INFO, "User in db using JPA save()"+user);
	}
}
