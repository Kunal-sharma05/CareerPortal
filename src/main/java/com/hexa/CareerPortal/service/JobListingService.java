package com.hexa.CareerPortal.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.JobListing;

public interface JobListingService {
	public JobListingDTO postJob(JobListingDTO jobListing);
	public List<JobListingDTO> postJobs(List<JobListingDTO> jobListing);
	public JobListingDTO updateRequirements(Long id,String requirements);
	public JobListingDTO updateDescription(Long id,String Description);
	public JobListingDTO updateTitle(Long id,String Title);
	public JobListingDTO findByJobListingId(Long Id);
	public List<JobListingDTO> findByRequirements(String requirements);
	public List<JobListingDTO> findByRequirementsContaining(String Requirement);
	public List<JobListingDTO> findByDescription(String description);
	public List<JobListingDTO> findByDescriptionContaining(String description);
	public List<JobListingDTO> findByTitle(String Title);
	public List<JobListingDTO> findByTitleContaining(String title);
	public List<JobListingDTO> findByDate(LocalDateTime Date);
	public List<JobListingDTO> findByTitleAndRequirementsContaining(String title,String Requirements);
	public JobListing deleteById(Long id);
	public List<JobListingDTO> deleteAll();
	public long count();
	public List<JobListingDTO> deleteAll(List<JobListing> jobListings);
	public List<JobListingDTO> findAll();
	//public List<JobListing> findAll(List<JobListing> jobListing);
	public JobListingDTO updateJobListing(Long jobListingId, JobListingDTO jobListingDTO);
	public JobListingDTO addingJobApplication(Long jobListingId, JobApplication jobApplication);
	public JobListingDTO updatingJobApplication(Long jobListingId, JobApplication jobApplication);
	
}
