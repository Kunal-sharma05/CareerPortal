package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
		Resume saveResume = resumeRepository.save(resume);
		return saveResume;
	}

	@Override
	public List<Resume> findResumes(List<Resume> resume) {
		List<Resume> saveResume = resumeRepository.saveAll(resume);
		return saveResume;
	}

	@Override
	public List<Resume> findAll(List<Resume> resume) {
		List<Resume> resumes = new ArrayList<>();
		resumes.addAll(resumeRepository.findAll());
		return resumes;
	}

	@Override
	public Resume findByResumeId(Long id) {
		Resume resume= resumeRepository.findById(id).orElse(null);
		return resume;
		
	}

	@Override
	public Resume deleteById(Long resumeId) {
		Resume resume= resumeRepository.findById(resumeId).orElse(null);
		if(resume!=null)
		{
			resumeRepository.deleteById(resumeId);
		}
		return resume;
	}

	@Override
	public List<Resume> deleteAll() {
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
		Long count=resumeRepository.count();
		return count;
	
	}

	@Override
	public List<Resume> deleteAll(List<Resume> resume) {
		List<Resume> resumes=new ArrayList<>();
		resumes.addAll(resume);
		if(resumes!=null)
		{
			resumeRepository.deleteAll(resume);
		}
		return resumes;
	}

	


}
