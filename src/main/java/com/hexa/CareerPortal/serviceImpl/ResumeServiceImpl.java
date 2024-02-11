package com.hexa.CareerPortal.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Resume;
import com.hexa.CareerPortal.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{

	@Override
	public Resume addResume(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findResumes(List<Resume> resumes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resume> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Resume> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteById(Long resumeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll(List<Resume> reumes) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public JobSeeker updateUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
