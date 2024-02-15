package com.hexa.CareerPortal.service;

import java.util.List;

import com.hexa.CareerPortal.entity.Employer;

public interface EmployerService {
	public Employer createEmployer(Employer employer);
	public List<Employer> createEmployers(List<Employer> employer);
	public Employer updateMobileNo(Employer employer,String mobileNo);
	public Employer updateEmail(Employer employer,String email);
	public Employer updateCompany(Employer employer,String company);
	public Employer findById(Long id);
	public List<Employer> findByCompanyName(String Name);
	public List<Employer> findByFullName(String fullName);
	public Employer findByEmail(String email);
	public Employer deleteById(Long id);
	public List<Employer> deleteAll();
	public long count();
	public List<Employer> deleteAll(List<Employer> employer);
	public List<Employer> findAll();
	public List<Employer> findAll(List<Employer> employers);
	
}
