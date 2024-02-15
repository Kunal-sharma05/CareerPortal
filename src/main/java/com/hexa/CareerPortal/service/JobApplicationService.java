package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;


public interface JobApplicationService {

	public JobApplication save(JobApplication jobApplication);
	public List<JobApplication> createJobApplication(List<JobApplication> jobApplication);
	public List<JobApplication> findAll();
	public JobApplication findById(Long id);
	public List<JobApplication> findByStatus(Status status);
	public JobApplication deleteById(Long jobApplicationId);
	public List<JobApplication> deleteAll();
	public long count();
	public List<JobApplication> deleteAll(List<JobApplication> jobApplications);
	public JobApplication updateStatus(JobApplication jobApplication,Status status);
	public JobApplication updatemobileNo(JobApplication jobApplications,String mobileno);
}
