package com.hexa.CareerPortal.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.JobListing;

import jakarta.validation.Valid;

public interface JobListingService {
	public JobListing postJob(JobListing jobListing);
	public List<JobListing> postJobs(List<JobListing> jobListing);
	public JobListing updateRequirements(Long id,String requirements);
	public JobListing updateDescription(Long id,String Description);
	public JobListing updateTitle(Long id,String Title);
	public JobListing findByJobListingId(Long Id);
	public List<JobListing> findByRequirements(String requirements);
	public List<JobListing> findByRequirementsContaining(String Requirement);
	public List<JobListing> findByDescription(String description);
	public List<JobListing> findByDescriptionContaining(String description);
	public List<JobListing> findByTitle(String Title);
	public List<JobListing> findByTitleContaining(String title);
	public List<JobListing> findByDate(LocalDateTime Date);
	public JobListing deleteById(Long id);
	public List<JobListing> deleteAll();
	public long count();
	public List<JobListing> deleteAll(List<JobListing> jobListing);
	public List<JobListing> findAll();
	//public List<JobListing> findAll(List<JobListing> jobListing);
	
}
