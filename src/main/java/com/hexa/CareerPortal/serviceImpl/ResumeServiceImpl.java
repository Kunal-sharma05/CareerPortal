package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.Resume;
import com.hexa.CareerPortal.repository.ResumeRepository;
import com.hexa.CareerPortal.service.ResumeService;


@Service
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ModelMapper modelMapper;
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
	public List<ResumeDTO> createUsers(List<ResumeDTO> resume) {
		List<Resume> resumes=resume.stream().map(userDTO->modelMapper.map(userDTO,Resume.class)).toList();
		List<Resume> savedUsers=resumeRepository.saveAll(resumes);
		resume=savedUsers.stream().map(User->modelMapper.map(savedUsers, ResumeDTO.class)).toList();
		return resume;
	}
	@Override
	public List<ResumeDTO> findAll() {
		List<Resume> users=new ArrayList<>();
		users.addAll(resumeRepository.findAll());
		List<ResumeDTO> user=users.stream().map(User->modelMapper.map(users, ResumeDTO.class)).toList();
		return user;
	}
	
	@Override
	public ResumeDTO findByResumeId(Long id) {
		Resume resume=resumeRepository.findByResumeId(id).orElse(null);
		ResumeDTO userDTO=modelMapper.map(resume, ResumeDTO.class);
		return userDTO;
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

	
	@Override
	public ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO) {
	    Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
	    ResumeDTO resumeDTOs=null;
	    if (optionalResume.isPresent()) {
	        Resume existingResume = optionalResume.get();
	        // Update the existing employer with the new information
	        existingResume.setFileUrl(resumeDTO.getFileUrl());
	        
	        Resume updatedEmployer = resumeRepository.save(existingResume);
	        
	        resumeDTOs=modelMapper.map(updatedEmployer, ResumeDTO.class);
	    }
	    return resumeDTOs;
	}



}
