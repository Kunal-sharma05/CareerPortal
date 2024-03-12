package com.hexa.CareerPortal.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.serviceImpl.JobSeekerServiceImpl;


@SpringBootTest
public class JobSeekerTest {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	JobSeekerServiceImpl jobSeekerServiceImpl;
	@Autowired
	JobSeekerRepository jobApplicationRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		JobSeekerDTO p=new JobSeekerDTO();
		JobSeekerDTO savedProduct=jobSeekerServiceImpl.createJobSeeker(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		JobSeekerDTO  existingProductOptional=jobSeekerServiceImpl.findByJobSeekerId(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setEmail("asim@gmail.com");
		existingProductOptional.setProfessionalDetails("SDE 2");
		existingProductOptional.setFullName("Asim Zohair");
		existingProductOptional.setMobileNumber("1234567890");
		existingProductOptional.setDateOfBirth(LocalDate.of(2012, 10, 10));

		
		JobSeekerDTO savedProduct=jobSeekerServiceImpl.createJobSeeker(existingProductOptional);
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
		//Iterable<JobSeeker> JobSeekerDTO=new ArrayList<>();
		
		//List<JobSeekerDTO> savedProductList=JobSeekerRepository.deleteAllInBatch(JobSeekerDTO);
		//LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<JobSeekerDTO> productList=jobSeekerServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		jobSeekerServiceImpl.deleteById(id);
		JobSeekerDTO opt=jobSeekerServiceImpl.findByJobSeekerId(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		JobSeekerDTO opt=jobSeekerServiceImpl.findByJobSeekerId(id);
		jobSeekerServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		jobSeekerServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		JobSeekerDTO p1 = jobSeekerServiceImpl.findByJobSeekerId(1L); // Use orElse(null) to handle the case when the entity is not found
	    JobSeekerDTO p2 = jobSeekerServiceImpl.findByJobSeekerId(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        jobSeekerServiceImpl.deleteAll();
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
		Long count=jobSeekerServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		JobSeekerDTO p=new JobSeekerDTO();
		JobSeekerDTO savedProduct=jobSeekerServiceImpl.createJobSeeker(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
