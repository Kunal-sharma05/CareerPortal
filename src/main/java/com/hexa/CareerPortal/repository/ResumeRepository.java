package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>   {

	
	public Optional<Resume> findByResumeId(Long id);
	public void deleteById(Long resumeId);
	public void deleteAll();
	public long count();
	public List<Resume> saveAll(List<Resume> resumes);
	public List<Resume> createResumes(List<Resume> resumes);

	
} 