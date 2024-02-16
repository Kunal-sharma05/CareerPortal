package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.entity.JobSeeker;

public interface JobSeekerService {


	public JobSeeker createJobSeeker(JobSeeker jobseeker);
	public List<JobSeeker> findJobSeeker(List<JobSeeker> jobseeker);
	public JobSeeker findByName(String name);
	public List<JobSeekerDTO> findAll();
	public JobSeekerDTO findByUserId(Long id);
	public JobSeeker findByEmail(String Email);
	public JobSeeker deleteById(Long id);
	public List<JobSeeker> deleteAll();
	public long count();
	public List<JobSeeker>  deleteAll(List<JobSeeker> jobseekers);
	public JobSeeker updateName(Long id,String name);
	public JobSeeker updateEmail(Long id, String email);
	public JobSeeker updatemobileNo(JobSeeker jobSeeker, String mobileNo);
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO);
	public JobSeekerDTO updateJobSeeker(Long id, JobSeekerDTO jobSeekerDto);
	public JobSeekerDTO updateJobSeekerDTO(Long jobSeekerId, JobSeekerDTO userDTO);
	public JobSeekerDTO findByJobSeekerId(Long id);
	
}
