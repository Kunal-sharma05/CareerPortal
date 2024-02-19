package com.hexa.CareerPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.repository.ResumeRepository;
import com.hexa.CareerPortal.serviceImpl.ResumeServiceImpl;


@SpringBootTest
public class Resume {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	ResumeServiceImpl resumeServiceImpl;
	@Autowired
	ResumeRepository jobApplicationRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		ResumeDTO p=new ResumeDTO();
		ResumeDTO savedProduct=resumeServiceImpl.addResume(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		ResumeDTO  existingProductOptional=resumeServiceImpl.findByResumeId(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setFileUrl("abcd.png");
		
		
		ResumeDTO savedProduct=resumeServiceImpl.addResume(existingProductOptional);
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
		List<ResumeDTO> ResumeDTO=new ArrayList<>();
		
		List<ResumeDTO> savedProductList=resumeServiceImpl.addResumes(ResumeDTO);
		LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<ResumeDTO> productList=resumeServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		resumeServiceImpl.deleteById(id);
		ResumeDTO opt=resumeServiceImpl.findByResumeId(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		ResumeDTO opt=resumeServiceImpl.findByResumeId(id);
		resumeServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		resumeServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		ResumeDTO p1 = resumeServiceImpl.findByResumeId(1L); // Use orElse(null) to handle the case when the entity is not found
	    ResumeDTO p2 = resumeServiceImpl.findByResumeId(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        resumeServiceImpl.deleteAll();
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
		Long count=resumeServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		ResumeDTO p=new ResumeDTO();
		ResumeDTO savedProduct=resumeServiceImpl.addResume(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
