package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Resume;
import com.hexa.CareerPortal.repository.ResumeRepository;
import com.hexa.CareerPortal.service.ResumeService;


@Service
public class ResumeServiceImpl implements ResumeService{

	private ResumeRepository resumeRepository;
	
	public ResumeServiceImpl(ResumeRepository resumeRepository){
		super();
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Resume addResume(Resume resume) {
		// TODO Auto-generated method stub
		Resume saveResume = resumeRepository.save(resume);
		return saveResume;
	}

	@Override
	public List<Resume> findResumes(List<Resume> resume) {
		// TODO Auto-generated method stub
		List<Resume> saveResume = resumeRepository.saveAll(resume);
		return saveResume;
	}

	@Override
	public List<Resume> findAll(List<Resume> resume) {
		// TODO Auto-generated method stub
		List<Resume> resumes = new ArrayList<>();
		resumes.addAll(resumeRepository.findAll());
		return resumes;
	}

	@Override
	public Resume findByResumeId(Long id) {
		// TODO Auto-generated method stub
		Resume resume= resumeRepository.findById(id).orElse(null);
		return resume;
		
	}

	@Override
	public Resume deleteById(Long resumeId) {
		// TODO Auto-generated method stub
		Resume resume= resumeRepository.findById(resumeId).orElse(null);
		if(resume!=null)
		{
			resumeRepository.deleteById(resumeId);
		}
		return resume;
	}

	@Override
	public List<Resume> deleteAll() {
		// TODO Auto-generated method stub
		List<Resume> resumes=new ArrayList<>();
		resumes.addAll(resumeRepository.findAll());
		if(resumes!=null)
		{
			resumeRepository.deleteAll();
		}
		return resumes;

		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		Long count=resumeRepository.count();
		return count;
	
	}

	@Override
	public List<Resume> deleteAll(List<Resume> resume) {
		// TODO Auto-generated method stub
		List<Resume> resumes=new ArrayList<>();
		resumes.addAll(resumeRepository.findAll(resume));
		if(resumes!=null)
		{
			resumeRepository.deleteAll(resume);
		}
		return resumes;
	}

	


}
