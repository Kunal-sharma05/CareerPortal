package com.hexa.CareerPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.ResumeDTO;

public interface ResumeService {
public ResumeDTO addResume(ResumeDTO resumeDTO);

	public ResumeDTO findByResumeId(Long id);
	public void deleteById(Long resumeId);
	public void deleteAll();
	public long count();
	public List<ResumeDTO> deleteAll(List<ResumeDTO> resume);

	public ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO);

	public List<ResumeDTO> findAll();

	

	public List<ResumeDTO> addResumes(List<ResumeDTO> resume);

	


	
}
