package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;
import com.hexa.CareerPortal.repository.JobApplicationRepository;
import com.hexa.CareerPortal.service.JobApplicationService;


@Service
public class JobApplicationServiceImpl implements JobApplicationService{

	@Autowired
	private ModelMapper modelMapper;
	private JobApplicationRepository jobApplicationRepository;
	
	public JobApplicationServiceImpl() {
		super();
	}


	@Override
	public JobApplicationDTO createJobApplication(JobApplicationDTO jobApplication) {
		JobApplication jobApplicationEntity=modelMapper.map(jobApplication, JobApplication.class);
		JobApplication savedjobApplication=jobApplicationRepository.save(jobApplicationEntity);
		jobApplication=modelMapper.map(savedjobApplication,JobApplicationDTO.class );
		return jobApplication;
	}

	@Override
	public List<JobApplicationDTO> createJobApplication(List<JobApplicationDTO> jobApplication) {
		List<JobApplication> jobApplications=jobApplication.stream().map(userDTO->modelMapper.map(userDTO,JobApplication.class)).toList();
		List<JobApplication> savedJobApplication=jobApplicationRepository.saveAll(jobApplications);
		jobApplication=savedJobApplication.stream().map(JobApplication->modelMapper.map(JobApplication, JobApplicationDTO.class)).toList();
		return jobApplication;
	}
	
	@Override
	public List<JobApplicationDTO> findAll() {
		List<JobApplication> jobApplications=new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.findAll());
		List<JobApplicationDTO> user=jobApplications.stream().map(User->modelMapper.map(jobApplications, JobApplicationDTO.class)).toList();
		return user;
	}
	@Override
	public JobApplicationDTO findByJobApplicationId(Long id) {
		JobApplication user=jobApplicationRepository.findById(id).orElse(null);
		JobApplicationDTO userDTO=modelMapper.map(user, JobApplicationDTO.class);
		return userDTO;
	}
	@Override
	public List<JobApplication> findByStatus(Status status) {
		List<JobApplication> jobApplications=new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.findByStatus(status));
		return jobApplications;
	}

	@Override
	public JobApplication deleteById(Long id) {
		JobApplication jobApplication= jobApplicationRepository.findById(id).orElse(null);
		if(jobApplication!=null)
		{
		jobApplicationRepository.deleteById(id);
		}
		return jobApplication;
	}

	@Override
	public List<JobApplication> deleteAll() {
		List<JobApplication> jobApplication=new ArrayList<>();
		jobApplication.addAll(jobApplicationRepository.findAll());
		if(jobApplication!=null)
		{
			jobApplicationRepository.deleteAll();
		}
		return jobApplication;
		
	}

	@Override
	public long count() {
		Long count = jobApplicationRepository.count();
		return count;
	}

	@Override
	public List<JobApplication> deleteAll(List<JobApplication> jobApplications) {
		List<JobApplication> jobApplication=new ArrayList<>();
		jobApplication.addAll(jobApplications);
		if(jobApplication!=null)
		{
			jobApplicationRepository.deleteAll(jobApplications);
		}
		return jobApplication;
		
	}

	@Override
	public JobApplication updateStatus(JobApplication jobApplication, Status status) {
		JobApplication jobApplications =jobApplicationRepository.findById(jobApplication.getJobApplicationId()).orElse(null);
		if(jobApplications!=null)
		{
			jobApplications.setStatus(status);
		}
		return jobApplications;
		
	}

	@Override
	public JobApplication updatemobileNo(JobApplication jobApplications, String mobileNo) {
		JobApplication jobApplication = jobApplicationRepository.findById(jobApplications.getJobApplicationId()).orElse(null);
		if(jobApplication!=null)
		{
			jobApplication.setMobileNo(mobileNo);
		}
		return jobApplication;

	}
	@Override
	public JobApplicationDTO updateJobApplication(Long jobApplicationId, JobApplicationDTO jobApplicationDTO) {
	    Optional<JobApplication> optionalEmployer = jobApplicationRepository.findById(jobApplicationId);
	    JobApplicationDTO employeDTO=null;
	    if (optionalEmployer.isPresent()) {
	    	JobApplication existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	        existingEmployer.setMobileNo(jobApplicationDTO.getMobileNumber());
	        
	        JobApplication updatedEmployer = jobApplicationRepository.save(existingEmployer);
	        
	        employeDTO=modelMapper.map(updatedEmployer,JobApplicationDTO.class);
	    }
	    return employeDTO;
	}
}
