package com.hexa.CareerPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.entity.Status;
import com.hexa.CareerPortal.repository.JobApplicationRepository;
import com.hexa.CareerPortal.serviceImpl.JobApplicationServiceImpl;


@SpringBootTest
public class JobApplicationTest {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	JobApplicationServiceImpl jobApplicationServiceImpl;
	@Autowired
	JobApplicationRepository jobApplicationRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		JobApplicationDTO p=new JobApplicationDTO();
		JobApplicationDTO savedProduct=jobApplicationServiceImpl.createJobApplication(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		JobApplicationDTO  existingProductOptional=jobApplicationServiceImpl.findByJobApplicationId(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setStatus(Status.PENDING);
		JobApplicationDTO savedProduct=jobApplicationServiceImpl.createJobApplication(existingProductOptional);
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
		List<JobApplicationDTO> JobApplicationDTO=new ArrayList<>();
		
		List<JobApplicationDTO> savedProductList=jobApplicationServiceImpl.createJobApplication(JobApplicationDTO);
		LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<JobApplicationDTO> productList=jobApplicationServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		jobApplicationServiceImpl.deleteById(id);
		JobApplicationDTO opt=jobApplicationServiceImpl.findByJobApplicationId(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		JobApplicationDTO opt=jobApplicationServiceImpl.findByJobApplicationId(id);
		jobApplicationServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		jobApplicationServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		JobApplicationDTO p1 = jobApplicationServiceImpl.findByJobApplicationId(1L); // Use orElse(null) to handle the case when the entity is not found
	    JobApplicationDTO p2 = jobApplicationServiceImpl.findByJobApplicationId(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        jobApplicationServiceImpl.deleteAll();
	        LOGGER.log(Level.INFO, "Records deleted: ");
	    } else {
	        LOGGER.log(Level.INFO, "Unable to delete records: One or both records not found");
	    }
	}
	@Disabled
	@Test
	void existByIdMethodTest()
	{
		boolean existStatus=jobApplicationRepository.existsById((long)2);
		LOGGER.log(Level.INFO, "Record found" +existStatus);
	}
	@Disabled
	@Test
	void countMethodTest()
	{
		Long count=jobApplicationServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		JobApplicationDTO p=new JobApplicationDTO();
		JobApplicationDTO savedProduct=jobApplicationServiceImpl.createJobApplication(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
