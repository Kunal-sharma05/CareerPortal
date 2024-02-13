package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;
import com.hexa.CareerPortal.repository.JobApplicationRepository;
import com.hexa.CareerPortal.service.JobApplicationService;


@Service
public class JobApplicationServiceImpl implements JobApplicationService{

	private JobApplicationRepository jobApplicationRepository;
	
	public JobApplicationServiceImpl() {
		super();
	}

	@Override
	public JobApplication save(JobApplication jobApplication) {
		JobApplication savedJobApplication = jobApplicationRepository.save(jobApplication);
		return savedJobApplication;
	}

	@Override
	public List<JobApplication> createJobApplication(List<JobApplication> jobApplication) {
		List<JobApplication> jobApplications=new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.saveAll(jobApplication));
		return jobApplications;
	
	}

	@Override
	public List<JobApplication> findAll() {
		List<JobApplication>jobApplications = new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.findAll());
		return jobApplications;
	}

	@Override
	public JobApplication findByUserId(Long id) {
		JobApplication jobApplication = jobApplicationRepository.findById(id).orElse(null);
		return jobApplication;
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

}
