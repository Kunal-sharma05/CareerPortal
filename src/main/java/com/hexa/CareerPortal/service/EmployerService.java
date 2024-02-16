package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.entity.Employer;

public interface EmployerService {
	public EmployerDTO createEmployer( EmployerDTO employerDTO);
	public List<EmployerDTO> createEmployers(List<EmployerDTO> employer);
	public Employer updateMobileNo(Employer employer,String mobileNo);
	public Employer updateEmail(Employer employer,String email);
	public Employer updateCompany(Employer employer,String company);
	public EmployerDTO findById(Long id);
	public List<Employer> findByCompanyName(String Name);
	public List<Employer> findByFullName(String fullName);
	public Employer findByEmail(String email);
	public Employer deleteById(Long id);
	public List<Employer> deleteAll();
	public long count();
	public List<Employer> deleteAll(List<Employer> employer);
	public List<EmployerDTO> findAll();
	public List<Employer> findAll(List<Employer> employers);
	public EmployerDTO updateEmployer(Long employerId, EmployerDTO employerDTO);
	
}
