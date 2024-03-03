package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public ResumeDTO addResume(ResumeDTO resume) {
		Resume resumeEntity=modelMapper.map(resume, Resume.class);
		Resume savedResume=resumeRepository.save(resumeEntity);
		resume=modelMapper.map(savedResume,ResumeDTO.class );
		return resume;
	}

	@Override
	public List<ResumeDTO> addResumes(List<ResumeDTO> resume) {
		List<Resume> resumes=resume.stream().map(entity->modelMapper.map(entity,Resume.class)).collect(Collectors.toList());
		List<Resume> savedUsers=resumeRepository.saveAll(resumes);
		resume=savedUsers.stream().map(dto->modelMapper.map(dto, ResumeDTO.class)).collect(Collectors.toList());
		return resume;
	}
	@Override
	public List<ResumeDTO> findAll() {
		List<Resume> resume=new ArrayList<>();
		resume.addAll(resumeRepository.findAll());
		List<ResumeDTO> resumeDTO=resume.stream().map(dto->modelMapper.map(dto, ResumeDTO.class)).collect(Collectors.toList());
		return resumeDTO;
	}
	
	@Override
	public ResumeDTO findByResumeId(Long id) {
		Resume resume=resumeRepository.findById(id).orElse(null);
		ResumeDTO resumeDTO=null;
		if(resume!=null)
		{
		resumeDTO=modelMapper.map(resume, ResumeDTO.class);
		}
		return resumeDTO;
	}
	@Override
	public void deleteById(Long resumeId) {
		Resume resume= resumeRepository.findById(resumeId).orElse(null);
		if(resume!=null)
		{
			resumeRepository.deleteById(resumeId);
		}
	}

	@Override
	public void deleteAll() {
		List<Resume> resumes=new ArrayList<>();
		resumes.addAll(resumeRepository.findAll());
		if(resumes!=null)
		{
			resumeRepository.deleteAll();
		}

		
	}

	@Override
	public long count() {
		Long count=resumeRepository.count();
		return count;
	
	}

	@Override
	public List<ResumeDTO> deleteAll(List<ResumeDTO> resume) {
		List<Resume> resumes=new ArrayList<>();
		resumes.addAll(resume.stream().map(dto->modelMapper.map(dto,Resume.class)).collect(Collectors.toList()));
		if(resumes!=null)
		{
			resumeRepository.deleteAll(resumes);
		}
		return resume;
	}

	
	@Override
	public ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO) {
	    Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
	    ResumeDTO resumeDTOs=null;
	    if (optionalResume.isPresent()) {
	        Resume existingResume = optionalResume.get();
	        
	        existingResume.setFileUrl(resumeDTO.getFileUrl());
	        
	        Resume updatedResume = resumeRepository.save(existingResume);
	        
	        resumeDTOs=modelMapper.map(updatedResume,ResumeDTO.class);
	    }
	    return resumeDTOs;
	}
}
