package com.hexa.CareerPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>   {
	public void deleteByResumeId(Long id);
	
} 