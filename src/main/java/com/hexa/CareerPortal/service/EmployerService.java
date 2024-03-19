package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.entity.JobListing;

public interface EmployerService {
	public EmployerDTO createEmployer( EmployerDTO employerDTO);
	public List<EmployerDTO> createEmployers(List<EmployerDTO> employer);
	public EmployerDTO updateMobileNo(Long id,String mobileNo);
	public EmployerDTO updateEmail(Long employerId,String email);
	public EmployerDTO updateCompany(Long employerId,String company);
	public EmployerDTO findById(Long id);
	public List<EmployerDTO> findByCompanyName(String Name);
	public List<EmployerDTO> findByFullName(String fullName);
	public EmployerDTO findByEmail(String email);
	public Employer deleteById(Long id);
	public List<EmployerDTO> deleteAll();
	public long count();
	public void deleteAll(List<EmployerDTO> employers);
	public List<EmployerDTO> findAll();
	public List<Employer> findAll(List<Employer> employers);
	public EmployerDTO updateEmployer(Long employerId, EmployerDTO employerDTO);
	EmployerDTO addJobListing(Long employerId, JobListingDTO jobListing);	
}
