package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Resume;
import com.hexa.CareerPortal.repository.JobListingRepository;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	public static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	@Autowired
	private JobListingRepository jobListingRepository;
	public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) 
	{
		super();
		this.jobSeekerRepository = jobSeekerRepository;
	}
	@Override
	public JobSeekerDTO updateName(Long id, String name) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElse(null);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
			jobSeeker.setFullName(name);
			jobSeekerDTO=modelMapper.map(jobSeeker,JobSeekerDTO.class );
			return jobSeekerDTO;
		}
		return jobSeekerDTO;
	}

	@Override
	public JobSeekerDTO updateEmail(Long id, String email) {
		JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
			jobSeeker.setEmail(email);
			jobSeekerDTO=modelMapper.map(jobSeeker,JobSeekerDTO.class );
			return jobSeekerDTO;
		}
		return jobSeekerDTO;
	}

	@Override
	public JobSeekerDTO updateMobileNo(Long id,String mobileNo) {
		JobSeeker jobSeeker=jobSeekerRepository.findById(id).orElse(null);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
			jobSeeker.setMobileNumber(mobileNo);
			jobSeekerDTO=modelMapper.map(jobSeeker,JobSeekerDTO.class );
			return jobSeekerDTO;
		}
		return jobSeekerDTO;
	
	}

	@Override
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO) {
		
		LOGGER.log(Level.INFO, "job Seeker in db using JPA save()"+jobSeekerDTO.toString());
		JobSeeker JobSeekerEntity=  modelMapper.map(jobSeekerDTO, JobSeeker.class);
		LOGGER.log(Level.INFO, "Job Seeker in db using JPA save()"+JobSeekerEntity.toString());
		JobSeeker savedJobSeeker= jobSeekerRepository.save(JobSeekerEntity);
		jobSeekerDTO=modelMapper.map(savedJobSeeker,JobSeekerDTO.class );
		return jobSeekerDTO;
	}

	@Override
	public List<JobSeekerDTO> findByName(String name) {
		List<JobSeeker> jobSeeker = jobSeekerRepository.findByFullName(name);
		List<JobSeekerDTO> jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
			jobSeekerDTO=jobSeeker.stream().map(js->modelMapper.map(js, JobSeekerDTO.class)).collect(Collectors.toList());
		}
		return jobSeekerDTO;
	}

	@Override
	public List<JobSeekerDTO> findAll() {
		List<JobSeeker> jobSeeker=new ArrayList<>();
		jobSeeker.addAll(jobSeekerRepository.findAll());
		List<JobSeekerDTO> jobSeekerDTO=jobSeeker.stream().map(js->modelMapper.map(js, JobSeekerDTO.class)).collect(Collectors.toList());
		return jobSeekerDTO;
	}
	

	@Override
	public JobSeekerDTO findByJobSeekerId(Long id) {
		JobSeeker jobSeeker= jobSeekerRepository.findById(id).orElse(null);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
		jobSeekerDTO=modelMapper.map(jobSeeker, JobSeekerDTO.class);
		}
		return jobSeekerDTO;
	}
	@Override
	public JobSeekerDTO findByEmail(String Email) {
		JobSeeker jobSeeker = jobSeekerRepository.findByEmail(Email);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
		jobSeekerDTO=modelMapper.map(jobSeeker, JobSeekerDTO.class);
		}
		return jobSeekerDTO;
	}

	@Override
	public JobSeekerDTO deleteById(Long jobSeekerId) {
		JobSeeker jobSeeker=jobSeekerRepository.findById(jobSeekerId).orElse(null);
		JobSeekerDTO jobSeekerDTO=null;
		if(jobSeeker!=null)
		{
		jobSeekerDTO=modelMapper.map(jobSeeker, JobSeekerDTO.class);
		jobSeekerRepository.deleteById(jobSeekerId);
		}
		return jobSeekerDTO;
		}

	@Override
	public void deleteAll() {
		List<JobSeeker> jobseekers = new ArrayList<>();
		jobseekers.addAll(jobSeekerRepository.findAll());
		if(jobseekers!= null)
		{
		jobSeekerRepository.deleteAll();
		}
	
	}
	@Override
	public long count() {
		Long count = jobSeekerRepository.count();
		return count;
	}

	@Override
	public JobSeekerDTO updateJobSeeker(Long jobSeekerId, JobSeekerDTO jobSeekerDTO) {
	    Optional<JobSeeker> optionalJobSeeker = jobSeekerRepository.findById(jobSeekerId);
	    JobSeekerDTO jobSeekerDTOLocal=null;
	    if (optionalJobSeeker.isPresent()) {
	        JobSeeker existingJobSeeker = optionalJobSeeker.get();
	        // Update the existing employer with the new information
	        existingJobSeeker.setFullName(jobSeekerDTO.getFullName());
	        existingJobSeeker.setMobileNumber(jobSeekerDTO.getMobileNumber());
	        existingJobSeeker.setEducationDetail(jobSeekerDTO.getEducationDetail());
	        existingJobSeeker.setProfessionalDetails(jobSeekerDTO.getProfessionalDetails());
	        existingJobSeeker.setEmail(jobSeekerDTO.getEmail());
	        existingJobSeeker.setImage(jobSeekerDTO.getImage());
	        existingJobSeeker.setDateOfBirth(jobSeekerDTO.getDateOfBirth());
	        
	        jobSeekerRepository.save(existingJobSeeker);
	        
	        jobSeekerDTOLocal= modelMapper.map(existingJobSeeker, JobSeekerDTO.class);
	    }
	    return jobSeekerDTOLocal;
	}
	@Override
	public List<JobSeekerDTO> findByProfessionalDetailsOrEducationDetailContaining(String details) {
		List<JobSeeker> jobSeeker=new ArrayList<>();
		jobSeeker.addAll(jobSeekerRepository.findByProfessionalDetailsContainingOrEducationDetailContaining(details, details));
		List<JobSeekerDTO> jobSeekerDTO=jobSeeker.stream().map(js->modelMapper.map(js, JobSeekerDTO.class)).collect(Collectors.toList());
		return jobSeekerDTO;
	}
	public JobSeekerDTO addJobApplication(Long jobSeekerId, JobApplicationDTO jobApplicationDto, Long jobId) {
	    Optional<JobSeeker> optionalJobSeeker = jobSeekerRepository.findById(jobSeekerId);
	    JobListing jobListing = jobListingRepository.findById(jobId).orElse(null);
	    JobSeekerDTO updatedJobSeekerDTO = null;
	    
	    if (optionalJobSeeker.isPresent() && jobListing != null) {
	        JobSeeker existingJobSeeker = optionalJobSeeker.get();
	        JobApplication jobApplication = modelMapper.map(jobApplicationDto, JobApplication.class);
	        
	        // Update JobSeeker
	        List<JobApplication> jobApplicationsForSeeker = existingJobSeeker.getJobApplication();
	        jobApplicationsForSeeker.add(jobApplication);
	        existingJobSeeker.setJobApplication(jobApplicationsForSeeker);
	        JobSeeker updatedJobSeeker = jobSeekerRepository.save(existingJobSeeker);
	        
	        // Update JobListing
	        List<JobApplication> jobApplicationsForListing = jobListing.getJobApplication();
	        jobApplicationsForListing.add(jobApplication);
	        jobListing.setJobApplication(jobApplicationsForListing);
	        jobListingRepository.save(jobListing);
	        
	        updatedJobSeekerDTO = modelMapper.map(updatedJobSeeker, JobSeekerDTO.class);
	    }
	    
	    return updatedJobSeekerDTO;
	}

	@Override
	public JobSeekerDTO addResume(Long jobSeekerId, ResumeDTO resumeDto) {
		Optional<JobSeeker> optionalJobSeeker = jobSeekerRepository.findById(jobSeekerId);
	    JobSeekerDTO updatedJobSeekerDTO=null;
	    if (optionalJobSeeker.isPresent())
	    {
	        JobSeeker existingJobSeeker = optionalJobSeeker.get();
	        List<Resume> list = existingJobSeeker.getResumes();
	        Resume resume=modelMapper.map(resumeDto, Resume.class);
	        list.add(resume);
	        existingJobSeeker.setResumes(list);
	        JobSeeker updatedJobSeeker = jobSeekerRepository.save(existingJobSeeker);
	        updatedJobSeekerDTO=modelMapper.map(updatedJobSeeker, JobSeekerDTO.class);
	    } 
	    return updatedJobSeekerDTO;
	}
	
}
