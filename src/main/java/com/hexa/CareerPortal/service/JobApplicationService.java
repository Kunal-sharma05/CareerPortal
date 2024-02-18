package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;


public interface JobApplicationService {

	public JobApplicationDTO createJobApplication(JobApplicationDTO jobApplication);
	
	public List<JobApplicationDTO> findAll();
	
	public List<JobApplication> findByStatus(Status status);//ww
	public JobApplication deleteById(Long jobApplicationId);
	public List<JobApplicationDTO> deleteAll();//
	public long count();//ww
	public List<JobApplicationDTO> deleteAll(List<JobApplicationDTO> jobApplications);
	public JobApplication updateStatus(JobApplication jobApplication,Status status);//ww
	public JobApplication updatemobileNo(JobApplication jobApplications,String mobileno);//ww
	public JobApplicationDTO updateJobApplication(Long jobApplicationId, JobApplicationDTO jobApplicationDTO);
	public List<JobApplicationDTO> createJobApplication(List<JobApplicationDTO> jobApplication);

	public JobApplicationDTO findByJobApplicationId(Long id);
}
