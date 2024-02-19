package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	@Autowired
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
		List<JobApplication> jobApplications=jobApplication.stream().map(userDTO->modelMapper.map(userDTO,JobApplication.class)).collect(Collectors.toList());
		List<JobApplication> savedJobApplication=jobApplicationRepository.saveAll(jobApplications);
		jobApplication=savedJobApplication.stream().map(JobApplication->modelMapper.map(JobApplication, JobApplicationDTO.class)).collect(Collectors.toList());
		return jobApplication;
	}
	
	@Override
	public List<JobApplicationDTO> findAll() {
		List<JobApplication> jobApplications=new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.findAll());
		List<JobApplicationDTO> user=jobApplications.stream().map(User->modelMapper.map(jobApplications, JobApplicationDTO.class)).collect(Collectors.toList());
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
	public void deleteAll() {
		List<JobApplication> jobApplication=new ArrayList<>();
		jobApplication.addAll(jobApplicationRepository.findAll());
		if(jobApplication!=null)
		{
			jobApplicationRepository.deleteAll();
		}
		
	}

	@Override
	public long count() {
		Long count = jobApplicationRepository.count();
		return count;
	}

	@Override
	public List<JobApplicationDTO> deleteAll(List<JobApplicationDTO> jobApplications) {
		List<JobApplicationDTO> jobApplication=new ArrayList<>();
		jobApplication.addAll(jobApplications);
		if(jobApplication!=null)
		{
			jobApplicationRepository.deleteAll();
		}
		return jobApplication;
		
	}

	@Override
	public JobApplicationDTO updateStatus(Long id, Status status) {
		JobApplication jobApplications =jobApplicationRepository.findById(id).orElse(null);
		JobApplicationDTO jobApplicationDTO=null;
		if(jobApplications!=null)
		{
			jobApplications.setStatus(status);
			jobApplicationRepository.save(jobApplications);
			jobApplicationDTO=modelMapper.map(jobApplications,JobApplicationDTO.class );
			
			
		}
		return jobApplicationDTO;
		
	}

	@Override
	public JobApplicationDTO updatemobileNo(Long id, String mobileNo) {
		JobApplication jobApplication = jobApplicationRepository.findById(id).orElse(null);
		JobApplicationDTO jobApplicationDTO=null;
		if(jobApplication!=null)
		{
			jobApplication.setMobileNo(mobileNo);
			jobApplicationRepository.save(jobApplication);
			jobApplicationDTO=modelMapper.map(jobApplication,JobApplicationDTO.class );
		}
		return jobApplicationDTO;

	}
	@Override
	public JobApplicationDTO updateJobApplication(Long jobApplicationId, JobApplicationDTO jobApplicationDTO) {
	    Optional<JobApplication> optionalEmployer = jobApplicationRepository.findById(jobApplicationId);
	    JobApplicationDTO employeDTO=null;
	    if (optionalEmployer.isPresent()) {
	    	JobApplication existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	    	existingEmployer.setStatus(jobApplicationDTO.getStatus());
	        
	        JobApplication updatedEmployer = jobApplicationRepository.save(existingEmployer);
	        
	        employeDTO=modelMapper.map(updatedEmployer,JobApplicationDTO.class);
	    }
	    return employeDTO;
	}

}


