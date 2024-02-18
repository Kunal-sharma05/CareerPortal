package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;


public interface JobApplicationService {

	public JobApplicationDTO createJobApplication(JobApplicationDTO jobApplication);
	
	public List<JobApplicationDTO> findAll();
	
	public List<JobApplication> findByStatus(Status status);
	public JobApplication deleteById(Long jobApplicationId);
	public void deleteAll();
	public long count();
	public List<JobApplicationDTO> deleteAll(List<JobApplicationDTO> jobApplications);
	public JobApplicationDTO updateStatus(Long id,Status status);
	public JobApplicationDTO updateJobApplication(Long jobApplicationId, JobApplicationDTO jobApplicationDTO);
	public List<JobApplicationDTO> createJobApplication(List<JobApplicationDTO> jobApplication);

	public JobApplicationDTO findByJobApplicationId(Long id);

	public JobApplicationDTO updatemobileNo(Long id, String mobileNo);
}
