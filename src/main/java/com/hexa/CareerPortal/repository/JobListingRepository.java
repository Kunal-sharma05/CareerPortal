package com.hexa.CareerPortal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobListing;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing,Long> {

	//public JobListing findByJobListingId(Long Id);
	public List<JobListing> findByRequirements(String requirements);
	public List<JobListing> findByRequirementsContaining(String Requirement);
	public List<JobListing> findByDescription(String description);
	public List<JobListing> findByDescriptionContaining(String description);
	public List<JobListing> findByTitle(String Title);
	public List<JobListing> findByTitleContaining(String title);
	public List<JobListing> findByTitleContainingAndRequirementsContaining(String title,String Requirements);
	public List<JobListing> findByDateOfPosting(LocalDateTime dateOfPosting);
	public void deleteById(Long id);
	public void deleteAll();
	public long count();
	//public void deleteAll(List<JobListing> jobListing);
	public List<JobListing> findAll();
	//public List<JobListing> findAll(List<JobListing> jobListing);
	
}
