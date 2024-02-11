package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>   {

	public JobSeeker createJobSeeker(JobSeeker jobseeker);
	public List<JobSeeker> findJobSeeker(List<JobSeeker> jobseeker);
	public Optional<JobSeeker> findByName(String name);
	public List<JobSeeker> findAll();
	public Optional<JobSeeker> findByUserId(Long id);
	public Optional<JobSeeker> findByEmail(String Email);
	public Optional<JobSeeker> findByMobileNo(String mobileNo);
	public JobSeeker deleteByID(Long jobSeekerId);
	public void deleteAll();
	public long count();
	public void deleteAll(List<JobSeeker> jobseekers);
	public List<JobSeeker> findAll(List<JobSeeker> jobseekers);
}
