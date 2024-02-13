package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.repository.JobSeekerRepository;
import com.hexa.CareerPortal.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	private JobSeekerRepository jobSeekerRepository;
	public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) 
	{
		super();
		this.jobSeekerRepository = jobSeekerRepository;
	}
	@Override
	public JobSeeker updateName(Long id, String name) {
		JobSeeker jobseeker = jobSeekerRepository.findById(id).orElse(null);
		if(jobseeker!=null)
		{
			jobseeker.setFullName(name);
		}
		return null;
	}

	@Override
	public JobSeeker updateEmail(Long id, String email) {
		// TODO Auto-generated method stub
		JobSeeker jobseeker = jobSeekerRepository.findByEmail(email);
		if(jobseeker!=null)
		{
			jobseeker.setEmail(email);
		}
		return jobseeker;
	}

	@Override
	public JobSeeker updatemobileNo(Long id,String mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobSeeker createJobSeeker(JobSeeker jobseeker) {
		// TODO Auto-generated method stub
		JobSeeker savedJobSeeker = jobSeekerRepository.save(jobseeker);
		return savedJobSeeker;
	}

	@Override
	public List<JobSeeker> findJobSeeker(List<JobSeeker> jobseeker) {
		// TODO Auto-generated method stub
		List<JobSeeker> jobseekers = jobSeekerRepository.saveAll(jobseeker);
		return jobseekers;
	}

	@Override
	public JobSeeker findByName(String name) {
		// TODO Auto-generated method stub
		JobSeeker jobseeker = jobSeekerRepository.findByFullName(name);
		return jobseeker;
	}

	@Override
	public List<JobSeeker> findAll() {
		// TODO Auto-generated method stub
		List<JobSeeker> jobseekers = new ArrayList<>();
		jobseekers.addAll(jobSeekerRepository.findAll());
		return jobseekers;
	}

	@Override
	public JobSeeker findByUserId(Long id) {
		JobSeeker jobseeker = jobSeekerRepository.findById(id).orElse(null);
		return jobseeker;
	}

	@Override
	public JobSeeker findByEmail(String Email) {
		// TODO Auto-generated method stub
		JobSeeker jobseeker = jobSeekerRepository.findByEmail(Email);
		return jobseeker;
	}

	@Override
	public JobSeeker findByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public JobSeeker deleteByID(Long jobSeekerId) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		List<JobSeeker> jobseeker=new ArrayList<>();
		jobseeker.addAll(jobseekers);
		if(jobseeker!=null)
		{
			jobSeekerRepository.deleteAll(jobseekers);
		}
		return jobseeker;
		
		
	}

}
