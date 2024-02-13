package com.hexa.CareerPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.Status;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{

	public List<JobApplication> findByStatus(Status status);
}
