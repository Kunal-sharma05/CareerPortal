package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	@Autowired
	private ModelMapper modelMapper;
	private JobSeekerRepository jobSeekerRepository;
	public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) 
	{
		super();
		this.jobSeekerRepository = jobSeekerRepository;
	}
	@Override
	public JobSeeker updateName(Long id, String name) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeeker.setFullName(name);
		}
		return jobSeeker;
	}

	@Override
	public JobSeeker updateEmail(Long id, String email) {
		JobSeeker jobseeker = jobSeekerRepository.findByEmail(email);
		if(jobseeker!=null)
		{
			jobseeker.setEmail(email);
		}
		return jobseeker;
	}

	@Override
	public JobSeeker updatemobileNo(JobSeeker jobSeekers,String mobileNo) {
		JobSeeker jobSeeker=jobSeekerRepository.findById(jobSeekers.getJobSeekerId()).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeeker.setMobileNumber(mobileNo);
		}
		return jobSeeker;
	
	}

	@Override
	public JobSeeker createJobSeeker(JobSeeker jobseeker) {
		JobSeeker savedJobSeeker = jobSeekerRepository.save(jobseeker);
		return savedJobSeeker;
	}

	@Override
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO) {
		JobSeeker userEntity=  modelMapper.map(jobSeekerDTO, JobSeeker.class);
		JobSeeker savedUser= jobSeekerRepository.save(userEntity);
		jobSeekerDTO=modelMapper.map(savedUser,JobSeekerDTO.class );
		return jobSeekerDTO;
	}
	@Override
	public List<JobSeeker> findJobSeeker(List<JobSeeker> jobseeker) {
		List<JobSeeker> jobseekers = jobSeekerRepository.saveAll(jobseeker);
		return jobseekers;
	}

	@Override
	public JobSeeker findByName(String name) {
		JobSeeker jobseeker = jobSeekerRepository.findByFullName(name);
		return jobseeker;
	}

	@Override
	public List<JobSeekerDTO> findAll() {
		List<JobSeeker> users=new ArrayList<>();
		users.addAll(jobSeekerRepository.findAll());
		List<JobSeekerDTO> user=users.stream().map(User->modelMapper.map(users, JobSeekerDTO.class)).toList();
		return user;
	}
	@Override
	public JobSeeker findByUserId(Long id) {
		JobSeeker jobseeker = jobSeekerRepository.findById(id).orElse(null);
		return jobseeker;
	}

	@Override
	public JobSeekerDTO findByJobSeekerId(Long id) {
		JobSeeker jobSeeker= jobSeekerRepository.findByJobSeekerId(id).orElse(null);
		JobSeekerDTO jobSeekerDTO=modelMapper.map(jobSeeker, JobSeekerDTO.class);
		return jobSeekerDTO;
	}
	@Override
	public JobSeeker findByEmail(String Email) {
		JobSeeker jobseeker = jobSeekerRepository.findByEmail(Email);
		return jobseeker;
	}

	@Override
	public JobSeeker deleteById(Long jobSeekerId) {
		JobSeeker jobSeeker=jobSeekerRepository.findById(jobSeekerId).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeekerRepository.deleteById(jobSeekerId);
		}
		return jobSeeker;
	}

	@Override
	public List <JobSeeker> deleteAll() {
		List<JobSeeker> jobseekers = new ArrayList<>();
		jobseekers.addAll(jobSeekerRepository.findAll());
		if(jobseekers!= null)
		{
		jobSeekerRepository.deleteAll();
		}
		return jobseekers ;
	
	}
	@Override
	public long count() {
		Long count = jobSeekerRepository.count();
		return count;
	}

	@Override
	public List<JobSeeker> deleteAll(List<JobSeeker> jobseekers) {
		List<JobSeeker> jobseeker=new ArrayList<>();
		jobseeker.addAll(jobseekers);
		if(jobseeker!=null)
		{
			jobSeekerRepository.deleteAll(jobseekers);
		}
		return jobseeker;
		
		
	}
	@Override
	public JobSeekerDTO updateJobSeekerDTO(Long jobSeekerId, JobSeekerDTO jobSeekerDTO) {
		JobSeeker jobSeeker= jobSeekerRepository.findById(jobSeekerId).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeeker.setEmail(jobSeekerDTO.getEmail());
			jobSeeker.setFullName(jobSeekerDTO.getFullName());
		    JobSeekerDTO updatedJobSeeker=new JobSeekerDTO(jobSeeker.getFullName(),jobSeeker.getEmail());
			return updatedJobSeeker;
		}
		
		return null;
	}
	
	public JobSeekerDTO updateJobSeeker(Long jobSeekerId, JobSeekerDTO jobSeekerDTO) {
	    Optional<JobSeeker> optionalEmployer = jobSeekerRepository.findById(jobSeekerId);
	    JobSeekerDTO jobSeekerDTO1=null;
	    if (optionalEmployer.isPresent()) {
	        JobSeeker existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	        existingEmployer.setFullName(jobSeekerDTO1.getFullName());
	        existingEmployer.setCompanyName(jobSeekerDTO1.getCompanyName());
	        existingEmployer.setMobileNumber(jobSeekerDTO1.getMobileNumber());
	        existingEmployer.setEmail(jobSeekerDTO1.getEmail());
	        
	        JobSeeker updatedEmployer = jobSeekerRepository.save(existingEmployer);
	        
	        jobSeekerDTO1= modelMapper.map(updatedEmployer, JobSeekerDTO.class);
	    }
	    return jobSeekerDTO1;
	}

}
