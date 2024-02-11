package com.hexa.CareerPortal.services;

import java.util.List;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;


public interface JobApplicationServices {

	public JobApplication save(JobApplication jobApplication);
	public List<JobApplication> findJobApplication(List<JobApplication> jobApplication);
	public List<JobApplication> findAll();
	public JobApplication findByUserId(Long id);
	public JobApplication findByStatus(Status status);
	public JobApplication deleteById(Long jobApplicationId);
	public void deleteAll();
	public long count();
	public void deleteAll(List<JobApplication> jobApplications);
	public JobApplication updateStatus(Status status);
	public JobApplication updatemobileNo(String mobileno);
}
