package com.hexa.CareerPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>   {

	public JobSeeker findByFullName(String name);
	//public List<JobSeeker> findAll();
	//Opublic JobSeeker findByUserId(Long id);
	public JobSeeker findByEmail(String Email);
	public JobSeeker findByMobileNumber(String mobileNo);
	//public JobSeeker deleteByID(Long jobSeekerId);
	public void deleteAll();
	public long count();
	//public void deleteAll(List<JobSeeker> jobseekers);
	//public List<JobSeeker> findAll(List<JobSeeker> jobseekers);
}
