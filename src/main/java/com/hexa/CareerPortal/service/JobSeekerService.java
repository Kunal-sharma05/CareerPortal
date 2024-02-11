package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.entity.JobSeeker;

public interface JobSeekerService {


	public JobSeeker createJobSeeker(JobSeeker jobseeker);
	public List<JobSeeker> findJobSeeker(List<JobSeeker> jobseeker);
	public JobSeeker findByName(String name);
	public List<JobSeeker> findAll();
	public JobSeeker findByUserId(Long id);
	public JobSeeker findByEmail(String Email);
	public JobSeeker findByMobileNo(String mobileNo);
	public JobSeeker deleteByID(Long id);
	public List<JobSeeker> deleteAll();
	public long count();
	public List<JobSeeker>  deleteAll(List<JobSeeker> jobseekers);
	public JobSeeker updateName(Long id,String name);
	public JobSeeker updateEmail(Long id, String email);
	public JobSeeker updatemobileNo(Long id, String mobileno);
	
}
