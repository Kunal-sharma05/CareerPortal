package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.entity.JobSeeker;

public interface JobSeekerService {


	public List<JobSeekerDTO> findJobSeeker(List<JobSeekerDTO> jobseeker);
	public List<JobSeekerDTO> findByName(String name);
	public List<JobSeekerDTO> findAll();
	public JobSeekerDTO findByJobSeekerId(Long id);
	public JobSeekerDTO findByEmail(String Email);
	public JobSeekerDTO deleteById(Long id);
	public List<JobSeekerDTO> deleteAll();
	public long count();
	public List<JobSeeker>  deleteAll(List<JobSeeker> jobseekers);
	public JobSeekerDTO updateName(Long id,String name);
	public JobSeekerDTO updateEmail(Long id, String email);
	public JobSeekerDTO updatemobileNo(JobSeeker jobSeeker, String mobileNo);
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO);
	public JobSeekerDTO updateJobSeeker(Long id, JobSeekerDTO jobSeekerDto);
	public JobSeekerDTO updateJobSeekerDTO(Long jobSeekerId, JobSeekerDTO userDTO);

	
}
