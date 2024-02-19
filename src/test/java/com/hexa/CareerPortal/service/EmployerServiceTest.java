package com.hexa.CareerPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.repository.EmployerRepository;
import com.hexa.CareerPortal.serviceImpl.EmployerServiceImpl;


@SpringBootTest
public class EmployerServiceTest {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	EmployerServiceImpl employerServiceImpl;
	@Autowired
	EmployerRepository employerRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		EmployerDTO p=new EmployerDTO();
		EmployerDTO savedProduct=employerServiceImpl.createEmployer(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		EmployerDTO  existingProductOptional=employerServiceImpl.findById(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setEmail("itsmekunal0501@gmail.com");
		existingProductOptional.setFullName(null);
		EmployerDTO savedProduct=employerServiceImpl.createEmployer(existingProductOptional);
		LOGGER.log(Level.INFO, "ExistingProduct in db using JPA save()"+savedProduct);
		}
		else
		{
			LOGGER.log(Level.INFO, "Existingproduct in db is not present)");
		}
	}
	@Disabled
	@Test
	public void saveAll()
	{
		List<EmployerDTO> EmployerDTO=new ArrayList<>();
		
		List<EmployerDTO> savedProductList=employerServiceImpl.createEmployers(EmployerDTO);
		LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<EmployerDTO> productList=employerServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		employerServiceImpl.deleteById(id);
		EmployerDTO opt=employerServiceImpl.findById(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		EmployerDTO opt=employerServiceImpl.findById(id);
		employerServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		employerServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		EmployerDTO p1 = employerServiceImpl.findById(1L); // Use orElse(null) to handle the case when the entity is not found
	    EmployerDTO p2 = employerServiceImpl.findById(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        employerServiceImpl.deleteAll();
	        LOGGER.log(Level.INFO, "Records deleted: ");
	    } else {
	        LOGGER.log(Level.INFO, "Unable to delete records: One or both records not found");
	    }
	}
	@Disabled
	@Test
	void existByIdMethodTest()
	{
		boolean existStatus=employerRepository.existsById((long)2);
		LOGGER.log(Level.INFO, "Record found" +existStatus);
	}
	@Disabled
	@Test
	void countMethodTest()
	{
		Long count=employerServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		EmployerDTO p=new EmployerDTO();
		EmployerDTO savedProduct=employerServiceImpl.createEmployer(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
