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

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	public static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
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
		
		LOGGER.log(Level.INFO, "User in db using JPA save()"+jobSeekerDTO.toString());
		JobSeeker JobSeekerEntity=  modelMapper.map(jobSeekerDTO, JobSeeker.class);
		LOGGER.log(Level.INFO, "User in db using JPA save()"+JobSeekerEntity.toString());
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
		List<JobSeeker> users=new ArrayList<>();
		users.addAll(jobSeekerRepository.findAll());
		List<JobSeekerDTO> user=users.stream().map(User->modelMapper.map(users, JobSeekerDTO.class)).collect(Collectors.toList());
		return user;
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
	    Optional<JobSeeker> optionalEmployer = jobSeekerRepository.findById(jobSeekerId);
	    JobSeekerDTO jobSeekerDTO1=null;
	    if (optionalEmployer.isPresent()) {
	        JobSeeker existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	        existingEmployer.setFullName(existingEmployer.getFullName());
	        existingEmployer.setMobileNumber(existingEmployer.getMobileNumber());
	        existingEmployer.setEmail(existingEmployer.getEmail());
	        
	        jobSeekerRepository.save(existingEmployer);
	        
	        jobSeekerDTO1= modelMapper.map(existingEmployer, JobSeekerDTO.class);
	    }
	    return jobSeekerDTO1;
	}
	
}
