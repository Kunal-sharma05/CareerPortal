package com.hexa.CareerPortal.service;

import java.util.List;
import java.util.Optional;

import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Resume;

public interface ResumeServices {

public Resume addResume(Resume resume);
	
	public List<Resume> findResumes(List<Resume> resumes);
	public List<Resume> findAll();
	public Optional<Resume> findByUserId(Long id);
	public void deleteById(Long resumeId);
	public void deleteAll();
	public long count();
	public void deleteAll(List<Resume> reumes);
	public JobSeeker updateUrl(String url);
	
}
