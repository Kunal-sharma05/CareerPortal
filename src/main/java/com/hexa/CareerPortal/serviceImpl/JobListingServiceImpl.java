package com.hexa.CareerPortal.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.repository.JobApplicationRepository;
import com.hexa.CareerPortal.repository.JobListingRepository;
import com.hexa.CareerPortal.service.JobListingService;

@Service
public class JobListingServiceImpl implements JobListingService {
	@Autowired
	private ModelMapper modelMapper;
	private JobListingRepository jobListingRepository;
	private JobApplicationRepository jobApplicationRepository;
	public JobListingServiceImpl(JobListingRepository jobListingRepository,JobApplicationRepository jobApplication) {
		super();
		this.jobListingRepository = jobListingRepository;
		this.jobApplicationRepository=jobApplication;
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
	            .collect(Collectors.toList());
	    List<JobListing> savedJobListings = jobListingRepository.saveAll(jobListings);		
	    List<JobListingDTO> savedJobListingsDTO=savedJobListings.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public JobListingDTO updateRequirements(Long id,String requirements) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		JobListingDTO jobListingDTO=null;
		if(jobListing!=null)
		{
			jobListing.setRequirements(requirements);
			jobListingRepository.save(jobListing);
			jobListingDTO= modelMapper.map(jobListing, JobListingDTO.class);
		}
		return jobListingDTO;
	}

	@Override
	public JobListingDTO findByJobListingId(Long id) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		JobListingDTO jobListingDTO= modelMapper.map(jobListing, JobListingDTO.class);
	    return jobListingDTO;
	}

	@Override
	public List<JobListingDTO> findByRequirements(String requirements) {
		List<JobListing> jobListing=jobListingRepository.findByRequirements(requirements);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
		}

	@Override
	public List<JobListingDTO> findByRequirementsContaining(String requirements) {
		List<JobListing> jobListing=jobListingRepository.findByRequirementsContaining(requirements);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public List<JobListingDTO> findByDescription(String description) {
		List<JobListing> jobListing=jobListingRepository.findByDescription(description);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}
	@Override
	public List<JobListingDTO> findByDescriptionContaining(String description) {
		List<JobListing> jobListing=jobListingRepository.findByDescriptionContaining(description);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public List<JobListingDTO> findByTitle(String title) {
		List<JobListing> jobListing=jobListingRepository.findByTitle(title);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public List<JobListingDTO> findByTitleContaining(String title) {
		List<JobListing> jobListing=jobListingRepository.findByTitleContaining(title);
		System.out.println("Job listing by title "+ jobListing);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public List<JobListingDTO> findByDate(LocalDateTime date) {
		List<JobListing> jobListing=jobListingRepository.findByDateOfPosting(date);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
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
	public List<JobListingDTO> deleteAll() {
		List<JobListing> jobListing=new ArrayList<>();
		jobListing.addAll(jobListingRepository.findAll());
		List<JobListingDTO> savedJobListingsDTO=null;
		if(jobListing!=null)
		{
			jobListingRepository.deleteAll();
			savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
		}
		return savedJobListingsDTO;

	}

	@Override
	public long count() {
		Long count=jobListingRepository.count();
		return count;
	}

	@Override
	public List<JobListingDTO> deleteAll(List<JobListing> jobListing) {
		List<JobListing> jobListings=new ArrayList<>();
		jobListings.addAll(jobListing);
		List<JobListingDTO> savedJobListingsDTO=null;
		if(jobListings!=null)
		{
			jobListingRepository.deleteAll(jobListing);
			savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
		}
		return savedJobListingsDTO;
	}

	@Override
	public JobListingDTO updateDescription(Long id, String description) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		JobListingDTO jobListingDTO=null;
		if(jobListing!=null)
		{
			jobListing.setDescription(description);
			jobListingRepository.save(jobListing);
			jobListingDTO= modelMapper.map(jobListing, JobListingDTO.class);
		}
		return jobListingDTO;

	}

	@Override
	public JobListingDTO updateTitle(Long id, String title) {
		JobListing jobListing=jobListingRepository.findById(id).orElse(null);
		JobListingDTO jobListingDTO=null;
		if(jobListing!=null)
		{
			jobListing.setTitle(title);
			jobListingRepository.save(jobListing);
			jobListingDTO= modelMapper.map(jobListing, JobListingDTO.class);
		}
		return jobListingDTO;
	}

	@Override
	public List<JobListingDTO> findAll() {
		List<JobListing> jobListing=new ArrayList<>();
		jobListing.addAll(jobListingRepository.findAll());
		 List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
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
	        existingJobListing.setImage(jobListingDTO.getImage());
//	        existingJobListing.setJobApplication(jobListingDTO.getJobApplication());
	        
	        JobListing updatedJobListing = jobListingRepository.save(existingJobListing);
	        
	        updatedJobListingDTO=modelMapper.map(updatedJobListing, JobListingDTO.class);
	    } 
	    return updatedJobListingDTO;
	}

	@Override
	public List<JobListingDTO> findByTitleAndRequirementsContaining(String title, String requirements) {
		List<JobListing> jobListing=jobListingRepository.findByTitleContainingAndRequirementsContaining(title,requirements);
		List<JobListingDTO> savedJobListingsDTO=jobListing.stream().map(job->modelMapper.map(job, JobListingDTO.class)).collect(Collectors.toList());
	    return savedJobListingsDTO;
	}

	@Override
	public JobListingDTO addingJobApplication(Long jobListingId, JobApplication jobApplication) {
		Optional<JobListing> optionalJobListing = jobListingRepository.findById(jobListingId);
	    JobListingDTO updatedJobListingDTO=null;
	    if (optionalJobListing.isPresent())
	    {
	        JobListing existingJobListing = optionalJobListing.get();
	        existingJobListing.addJobApplication(jobApplication);
	        JobListing updatedJobListing = jobListingRepository.save(existingJobListing);
	        updatedJobListingDTO=modelMapper.map(updatedJobListing, JobListingDTO.class);
	    } 
	    return updatedJobListingDTO;
	}
	@Override
	public JobListingDTO updatingJobApplication(Long jobListingId, JobApplication jobApplication) {
		Optional<JobListing> optionalJobListing = jobListingRepository.findById(jobListingId);
	    JobListingDTO updatedJobListingDTO=null;
	    if (optionalJobListing.isPresent())
	    {
            JobListing existingJobListing = optionalJobListing.get();
	        JobApplication jobApplication1=jobApplicationRepository.findById(jobApplication.getJobApplicationId()).orElse(null);
	        jobApplication1.setStatus(jobApplication.getStatus());
	        System.out.println(jobApplication1);
	        jobApplicationRepository.save(jobApplication1);
//	        JobListing updatedJobListing = jobListingRepository.save(existingJobListing);
	        
	        updatedJobListingDTO=modelMapper.map(existingJobListing, JobListingDTO.class);
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
