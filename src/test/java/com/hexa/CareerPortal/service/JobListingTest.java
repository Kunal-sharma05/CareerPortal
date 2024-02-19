package com.hexa.CareerPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.repository.JobListingRepository;
import com.hexa.CareerPortal.serviceImpl.JobListingServiceImpl;



@SpringBootTest
public class JobListingTest {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	JobListingServiceImpl jobListingServiceImpl;
	@Autowired
	JobListingRepository jobListingRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		JobListingDTO p=new JobListingDTO();
		JobListingDTO savedProduct=jobListingServiceImpl.postJob(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		JobListingDTO  existingProductOptional=jobListingServiceImpl.findByJobListingId(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setTitle("SDE 1");
		existingProductOptional.setRequirements("Everything");
		existingProductOptional.setDescription("Full Stack needed");
		
		JobListingDTO savedProduct=jobListingServiceImpl.postJob(existingProductOptional);
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
		List<JobListingDTO> JobListingDTO=new ArrayList<>();
		
		List<JobListingDTO> savedProductList=jobListingServiceImpl.postJobs(JobListingDTO);
		LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<JobListingDTO> productList=jobListingServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		jobListingServiceImpl.deleteById(id);
		JobListingDTO opt=jobListingServiceImpl.findByJobListingId(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		JobListingDTO opt=jobListingServiceImpl.findByJobListingId(id);
		jobListingServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		jobListingServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		JobListingDTO p1 = jobListingServiceImpl.findByJobListingId(1L); // Use orElse(null) to handle the case when the entity is not found
	    JobListingDTO p2 = jobListingServiceImpl.findByJobListingId(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        jobListingServiceImpl.deleteAll();
	        LOGGER.log(Level.INFO, "Records deleted: ");
	    } else {
	        LOGGER.log(Level.INFO, "Unable to delete records: One or both records not found");
	    }
	}
	@Disabled
	@Test
	void existByIdMethodTest()
	{
		boolean existStatus=jobListingRepository.existsById((long)2);
		LOGGER.log(Level.INFO, "Record found" +existStatus);
	}
	@Disabled
	@Test
	void countMethodTest()
	{
		Long count=jobListingServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		JobListingDTO p=new JobListingDTO();
		JobListingDTO savedProduct=jobListingServiceImpl.postJob(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
