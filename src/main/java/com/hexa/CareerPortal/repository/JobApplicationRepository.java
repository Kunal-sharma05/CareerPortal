package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{

	@SuppressWarnings("unchecked")
	public JobApplication save(JobApplication jobApplication);
	public List<JobApplication> findJobApplication(List<JobApplication> jobApplication);
	public List<JobApplication> findAll();
	public Optional<JobApplication> findByUserId(Long id);
	public JobApplication findByStatus(Status status);
	public void deleteById(Long jobApplicationId);
	public void deleteAll();
	public long count();
	public void deleteAll(List<JobApplication> jobApplications);
}
