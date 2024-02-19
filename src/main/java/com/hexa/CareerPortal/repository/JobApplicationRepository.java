package com.hexa.CareerPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;


public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{

	public List<JobApplication> findByStatus(Status status);
}
