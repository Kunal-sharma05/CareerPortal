package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.JobSeeker;

public interface JobSeekerService {


	public List<JobSeekerDTO> findByName(String name);
	public List<JobSeekerDTO> findAll();
	public JobSeekerDTO findByJobSeekerId(Long id);
	public JobSeekerDTO findByEmail(String Email);
	public JobSeekerDTO deleteById(Long id);
	public void deleteAll();
	public long count();
	public JobSeekerDTO updateName(Long id,String name);
	public JobSeekerDTO updateEmail(Long id, String email);
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO);
	public JobSeekerDTO updateJobSeeker(Long id, JobSeekerDTO jobSeekerDto);
	public JobSeekerDTO updateMobileNo(Long id, String mobileNo);
	public List<JobSeekerDTO> findByProfessionalDetailsOrEducationDetailContaining(String details);
	JobSeekerDTO addJobApplication(Long jobSeekerId, JobApplicationDTO jobApplicationDto,Long jobId);
	JobSeekerDTO addResume(Long jobSeekerId, ResumeDTO ResumeDto);

	
}
