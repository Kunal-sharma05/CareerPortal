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
	public JobSeekerDTO updateName(Long id, String name) {
		JobSeekerDTO jobSeeker = jobSeekerRepository.findById(id).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeeker.setFullName(name);
		}
		return jobSeeker;
	}

	@Override
	public JobSeekerDTO updateEmail(Long id, String email) {
		JobSeekerDTO jobseeker = jobSeekerRepository.findByEmail(email);
		if(jobseeker!=null)
		{
			jobseeker.setEmail(email);
		}
		return jobseeker;
	}

	@Override
	public JobSeekerDTO updatemobileNo(JobSeeker jobSeekers,String mobileNo) {
		JobSeekerDTO jobSeeker=jobSeekerRepository.findById(jobSeekers.getJobSeekerId()).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeeker.setMobileNumber(mobileNo);
		}
		return jobSeeker;
	
	}

	@Override
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO) {
		JobSeekerDTO JobSeekerEntity=  modelMapper.map(jobSeekerDTO, JobSeekerDTO.class);
		JobSeekerDTO savedJobSeeker= jobSeekerRepository.save(JobSeekerEntity);
		jobSeekerDTO=modelMapper.map(savedJobSeeker,JobSeekerDTO.class );
		return jobSeekerDTO;
	}
	@Override
	public List<JobSeekerDTO> findJobSeeker(List<JobSeekerDTO> jobseeker) {
		List<JobSeekerDTO> jobseekers = jobSeekerRepository.saveAll(jobseeker);
		return jobseekers;
	}

	@Override
	public List<JobSeekerDTO> findByName(String name) {
		List<JobSeekerDTO> jobseeker = jobSeekerRepository.findByFullName(name);
		return jobseeker;
	}

	@Override
	public List<JobSeekerDTO> findAll() {
		List<JobSeekerDTO> users=new ArrayList<>();
		users.addAll(jobSeekerRepository.findAll());
		List<JobSeekerDTO> user=users.stream().map(User->modelMapper.map(users, JobSeekerDTO.class)).toList();
		return user;
	}
	

	@Override
	public JobSeekerDTO findByJobSeekerId(Long id) {
		JobSeekerDTO jobSeeker= jobSeekerRepository.findByJobSeekerId(id).orElse(null);
		JobSeekerDTO jobSeekerDTO=modelMapper.map(jobSeeker, JobSeekerDTO.class);
		return jobSeekerDTO;
	}
	@Override
	public JobSeekerDTO findByEmail(String Email) {
		JobSeekerDTO jobseeker = jobSeekerRepository.findByEmail(Email);
		return jobseeker;
	}

	@Override
	public JobSeekerDTO deleteById(Long jobSeekerId) {
		JobSeekerDTO jobSeeker=jobSeekerRepository.findById(jobSeekerId).orElse(null);
		if(jobSeeker!=null)
		{
			jobSeekerRepository.deleteById(jobSeekerId);
		}
		return jobSeeker;
	}

	@Override
	public List<JobSeekerDTO> deleteAll() {
		List<JobSeekerDTO> jobseekers = new ArrayList<>();
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
			jobSeekerRepository.deleteAll();
		}
		return jobseeker;
		
		
	}
	@Override
	public JobSeekerDTO updateJobSeekerDTO(Long jobSeekerId, JobSeekerDTO jobSeekerDTO) {
		JobSeekerDTO jobSeeker= jobSeekerRepository.findById(jobSeekerId).orElse(null);
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
	    Optional<JobSeekerDTO> optionalEmployer = jobSeekerRepository.findById(jobSeekerId);
	    JobSeekerDTO jobSeekerDTO1=null;
	    if (optionalEmployer.isPresent()) {
	        JobSeekerDTO existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	        existingEmployer.setFullName(jobSeekerDTO1.getFullName());
	        existingEmployer.setMobileNumber(jobSeekerDTO1.getMobileNumber());
	        existingEmployer.setEmail(jobSeekerDTO1.getEmail());
	        
	        JobSeekerDTO updatedEmployer = jobSeekerRepository.save(existingEmployer);
	        
	        jobSeekerDTO1= modelMapper.map(updatedEmployer, JobSeekerDTO.class);
	    }
	    return jobSeekerDTO1;
	}
	
}
