package com.hexa.CareerPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>   {

	public List<JobSeeker> findByFullName(String name);
	public JobSeeker findByEmail(String Email);
	public void deleteAll();
	public long count();
	public List<JobSeeker> findByProfessionalDetailsContainingOrEducationDetailContaining(String professionalDetails, String educationDetail);
}
