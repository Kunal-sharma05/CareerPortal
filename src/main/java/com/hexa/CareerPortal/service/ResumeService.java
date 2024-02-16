package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.Resume;

public interface ResumeService {

public ResumeDTO addResume(ResumeDTO resumeDTO);

	public ResumeDTO findByResumeId(Long id);
	public Resume deleteById(Long resumeId);
	public List<Resume> deleteAll();
	public long count();
	public List<Resume> deleteAll(List<Resume> resume);

	public ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO);

	public List<ResumeDTO> findAll();

	

	public List<ResumeDTO> addResumes(List<ResumeDTO> resume);
	
	
}
