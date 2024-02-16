package com.hexa.CareerPortal.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.repository.JobListingRepository;
import com.hexa.CareerPortal.service.JobListingService;

import jakarta.validation.Valid;

@Service
public class JobListingServiceImpl implements JobListingService {
	@Autowired
	private ModelMapper modelMapper;
	private JobListingRepository jobListingRepository;
	public JobListingServiceImpl(JobListingRepository jobListingRepository) {
		super();
		this.jobListingRepository = jobListingRepository;
	}

	@Override
	public JobListingDTO postJob(JobListingDTO jobListingDTO) {
	    JobListing jobListing = modelMapper.map(jobListingDTO, JobListing.class);
	    JobListing savedJobListing = jobListingRepository.save(jobListing);
	    jobListingDTO= modelMapper.map(savedJobListing, JobListingDTO.class);
	    return jobListingDTO;
	}

	@Override
	public List<JobListingDTO> postJobs(List<JobListingDTO> jobListingDTOs) {
	    List<JobListing> jobListings = jobListingDTOs.stream()
	            .map(jobListingDTO -> modelMapper.map(jobListingDTO, JobListing.class))
	            .toList();
	    List<JobListing> savedJobListings = jobListingRepository.saveAll(jobListings);		
	    List<JobListingDTO> savedJobListingsDTO=savedJobListings.stream().map(job->modelMapper.map(job, JobListingDTO.class)).toList();
	    return savedJobListingsDTO;
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
	public JobListingDTO findByJobListingId(Long id) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		JobListingDTO jobListingDTO= modelMapper.map(jobListing, JobListingDTO.class);
	    return jobListingDTO;
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
		List<JobListing> jobListing=jobListingRepository.findByDateOfPosting(date);
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
		jobListings.addAll(jobListing);
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
	public List<JobListingDTO> findAll() {
		List<JobListing> jobListing=new ArrayList<>();
		jobListing.addAll(jobListingRepository.findAll());
		 List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).toList();
		  return savedJobListingsDTO;
	}


	@Override
	public JobListingDTO updateJobListing(Long jobListingId, JobListingDTO jobListingDTO) {
	    Optional<JobListing> optionalJobListing = jobListingRepository.findById(jobListingId);
	    JobListingDTO updatedJobListingDTO=null;
	    if (optionalJobListing.isPresent()) {
	        JobListing existingJobListing = optionalJobListing.get();

	        existingJobListing.setTitle(jobListingDTO.getTitle());
	        existingJobListing.setDescription(jobListingDTO.getDescription());
	        existingJobListing.setRequirements(jobListingDTO.getRequirements());
	        
	        JobListing updatedJobListing = jobListingRepository.save(existingJobListing);
	        
	        updatedJobListingDTO=modelMapper.map(updatedJobListing, JobListingDTO.class);
	    } 
	    return updatedJobListingDTO;
	}


	/*
	 * @Override public List<JobListing> findAll(List<JobListing> jobListing) {
	 * List<JobListing> jobListings=new ArrayList<>();
	 * jobListings.addAll(jobListingRepository.findAll(jobListing)); return
	 * jobListings; }
	 */

}
