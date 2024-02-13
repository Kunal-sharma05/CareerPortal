package com.hexa.CareerPortal.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.repository.JobListingRepository;
import com.hexa.CareerPortal.service.JobListingService;

@Service
public class JobListingServiceImpl implements JobListingService {
	private JobListingRepository jobListingRepository;
	public JobListingServiceImpl(JobListingRepository jobListingRepository) {
		super();
		this.jobListingRepository = jobListingRepository;
	}

	@Override
	public JobListing postJob(JobListing jobListing) {
		JobListing saveJobListing=jobListingRepository.save(jobListing);
		return saveJobListing;
	}

	@Override
	public List<JobListing> postJobs(List<JobListing> jobListing) {
		List<JobListing> savedJobListings=jobListingRepository.saveAll(jobListing);
		return savedJobListings;
	}

	@Override
	public JobListing updateRequirements(Long id,String requirements) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		if(jobListing!=null)
		{
			jobListing.setRequirements(requirements);
		}
		return jobListing;
	}

	@Override
	public JobListing findByJobListingId(Long id) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		return jobListing;
	}

	@Override
	public List<JobListing> findByRequirements(String requirements) {
		List<JobListing> jobListing=jobListingRepository.findByRequirements(requirements);
		return jobListing;	
		}

	@Override
	public List<JobListing> findByRequirementsContaining(String requirements) {
		List<JobListing> jobListing=jobListingRepository.findByRequirementsContaining(requirements);
		return jobListing;
	}

	@Override
	public List<JobListing> findByDescription(String description) {
		List<JobListing> jobListing=jobListingRepository.findByDescription(description);
		return jobListing;	
		}

	@Override
	public List<JobListing> findByDescriptionContaining(String description) {
		List<JobListing> jobListing=jobListingRepository.findByDescriptionContaining(description);
		return jobListing;	
	}

	@Override
	public List<JobListing> findByTitle(String title) {
		List<JobListing> jobListing=jobListingRepository.findByTitle(title);
		return jobListing;	
		}

	@Override
	public List<JobListing> findByTitleContaining(String title) {
		List<JobListing> jobListing=jobListingRepository.findByTitleContaining(title);
		return jobListing;		
		}

	@Override
	public List<JobListing> findByDate(LocalDateTime date) {
		List<JobListing> jobListing=jobListingRepository.findByDate(date);
		return jobListing;	
		}

	@Override
	public JobListing deleteById(Long id) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		if(jobListing!=null)
		{
			jobListingRepository.deleteById(id);
		}
		return jobListing;
	}

	@Override
	public List<JobListing> deleteAll() {
		List<JobListing> jobListing=new ArrayList<>();
		jobListing.addAll(jobListingRepository.findAll());
		if(jobListing!=null)
		{
			jobListingRepository.deleteAll();
		}
		return jobListing;

	}

	@Override
	public long count() {
		Long count=jobListingRepository.count();
		return count;
	}

	@Override
	public List<JobListing> deleteAll(List<JobListing> jobListing) {
		List<JobListing> jobListings=new ArrayList<>();
		jobListings.addAll(jobListingRepository.findAll(jobListing));
		if(jobListings!=null)
		{
			jobListingRepository.deleteAll(jobListing);
		}
		return jobListings;
	}

	@Override
	public JobListing updateDescription(Long id, String description) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		if(jobListing!=null)
		{
			jobListing.setRequirements(description);
		}
		return jobListing;
	}

	@Override
	public JobListing updateTitle(Long id, String title) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		if(jobListing!=null)
		{
			jobListing.setTitle(title);
		}
		return jobListing;
	}

	@Override
	public List<JobListing> findAll() {
		List<JobListing> jobListing=new ArrayList<>();
		jobListing.addAll(jobListingRepository.findAll());
		return jobListing;
	}

	@Override
	public List<JobListing> findAll(List<JobListing> jobListing) {
		List<JobListing> jobListings=new ArrayList<>();
		jobListings.addAll(jobListingRepository.findAll(jobListing));
		return jobListings;	
		}

}
