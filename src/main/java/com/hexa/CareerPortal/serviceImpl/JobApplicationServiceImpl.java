package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;
import com.hexa.CareerPortal.repository.JobApplicationRepository;
import com.hexa.CareerPortal.services.JobApplicationServices;

@Service
public class JobApplicationServiceImpl implements JobApplicationServices{

	private JobApplicationRepository jobApplicationRepository;
	
	public JobApplicationServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JobApplication save(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		JobApplication savedJobApplication = jobApplicationRepository.save(jobApplication);
		return savedJobApplication;
	}

	@Override
	public List<JobApplication> findJobApplication(List<JobApplication> jobApplication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobApplication> findAll() {
		// TODO Auto-generated method stub
		List<JobApplication>jobApplications = new ArrayList<>();
		jobApplications.addAll(jobApplicationRepository.findAll());
		return jobApplications;
	}

	@Override
	public JobApplication findByUserId(Long id) {
		// TODO Auto-generated method stub
		JobApplication jobApplication = jobApplicationRepository.findByUserId(id).orElse(null);
		return jobApplication;
	}

	@Override
	public JobApplication findByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplication deleteById(Long id) {
		// TODO Auto-generated method stub
		JobApplication jobApplication= jobApplicationRepository.findById(id).orElse(null);
		if(jobApplication!=null)
		{
		jobApplicationRepository.deleteById(id);
		}
		return jobApplication;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		Long count = jobApplicationRepository.count();
		return count;
	}

	@Override
	public void deleteAll(List<JobApplication> jobApplications) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobApplication updateStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplication updatemobileNo(String mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

}
