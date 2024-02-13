package com.hexa.CareerPortal.service;

import java.util.List;
import java.util.Optional;

import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Resume;

public interface ResumeService {

public Resume addResume(Resume resume);
	
	public List<Resume> findResumes(List<Resume> resume);
	public List<Resume> findAll(List<Resume> resume);
	public Resume findByResumeId(Long id);
	public Resume deleteById(Long resumeId);
	public List<Resume> deleteAll();
	public long count();
	public List<Resume> deleteAll(List<Resume> resume);
	
	
}
