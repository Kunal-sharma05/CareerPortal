package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.repository.EmployerRepository;
import com.hexa.CareerPortal.service.EmployerService;

public class EmployerRepositoryImpl implements EmployerService {
	private EmployerRepository employerRepository;
	public EmployerRepositoryImpl(EmployerRepository employerRepository) {
		super();
		this.employerRepository = employerRepository;
	}

	@Override
	public Employer createEmployer(Employer employer) {
		Employer employer1=employerRepository.save(employer);
		return employer1;
	}

	@Override
	public List<Employer> createEmployers(List<Employer> employer) {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.saveAll(employer));
		return employers;

	}

	@Override
	public Employer updateMobileNo(Employer employer,String mobileNumber) {
		Employer employe=employerRepository.findById(employer.getEmployerId()).orElse(null);
		if(employe!=null)
		{
			employe.setMobileNo(mobileNumber);
		}
		return employe;
	}

	@Override
	public Employer updateEmail(Employer employer,String email) {
		Employer employe=employerRepository.findById(employer.getEmployerId()).orElse(null);
		if(employe!=null)
		{
			employe.setEmail(email);
		}
		return employe;
	}

	@Override
	public Employer updateCompany(Employer employer,String companyName ) {
		Employer employe=employerRepository.findById(employer.getEmployerId()).orElse(null);
		if(employe!=null)
		{
			employe.setCompanyName(companyName);
		}
		return employe;
	}

	@Override
	public Employer findById(Long id) {
		Employer employe=employerRepository.findById(id).orElse(null);
		return employe;
	}

	@Override
	public List<Employer> findByCompanyName(String name) {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findByCompanyName(name).orElse(null));
		return employers;
	}

	@Override
	public Employer findByEmail(String email) {
		Employer employe=employerRepository.findByEmail(email).orElse(null);
		return employe;
	}

	@Override
	public Employer deleteById(Long id) {
		Employer employe=employerRepository.findById(id).orElse(null);
		if(employe!=null)
		{
			employerRepository.deleteById(id);
		}
		return employe;
	}

	@Override
	public List<Employer> deleteAll() {
		List<Employer> employer=employerRepository.findAll();
		if(employer!=null)
		{
			employerRepository.deleteAll();
		}
		return employer;

	}

	@Override
	public long count() {
		Long count=employerRepository.count();
		return count;
	}

	@Override
	public List<Employer> deleteAll(List<Employer> employer) {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findAll(employer).orElse(null));
		if(employers!=null)
		{
			employerRepository.deleteAll(employer);
		}
		return employer;

	}

	@Override
	public List<Employer> findAll() {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findAll());
		return employers;
	}

	@Override
	public List<Employer> findAll(List<Employer> employers) {
		List<Employer> employer=new ArrayList<>();
		employer.addAll(employerRepository.findAll(employers).orElse(null));
		return employer;
	}

}
