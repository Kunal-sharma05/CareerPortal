package com.hexa.CareerPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.repository.EmployerRepository;
import com.hexa.CareerPortal.service.EmployerService;
@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private ModelMapper modelMapper;
	private EmployerRepository employerRepository;
	public EmployerServiceImpl(EmployerRepository employerRepository) {
		super();
		this.employerRepository = employerRepository;
	}

	@Override
	public EmployerDTO createEmployer(EmployerDTO employer) {
		Employer employerEntity=modelMapper.map(employer, Employer.class);
		Employer employer1=employerRepository.save(employerEntity);
		employer=modelMapper.map(employer1,EmployerDTO.class);
		return employer;
	}

	@Override
	public List<EmployerDTO> createEmployers(List<EmployerDTO> employer) {
		List<Employer> employers=employer.stream().map(employer1->modelMapper.map(employer1, Employer.class)).collect(Collectors.toList());
		employers.addAll(employerRepository.saveAll(employers));
		employer=null;
		if(employers!=null)
		{
		employer=employers.stream().map(employer1->modelMapper.map(employer1, EmployerDTO.class)).collect(Collectors.toList());
		}
		return employer;

	}

	@Override
	public EmployerDTO updateMobileNo(Long id,String mobileNumber) {
		Employer employe=employerRepository.findById(id).orElse(null);
		EmployerDTO employer=null;
		if(employe!=null)
		{
			employe.setMobileNo(mobileNumber);
			employerRepository.save(employe);
			employer=modelMapper.map(employe,EmployerDTO.class);
			return employer;
		}
		return employer;
	}

	@Override
	public EmployerDTO updateEmail(Long id,String email) {
		Employer employe=employerRepository.findById(id).orElse(null);
		EmployerDTO employer=null;
		if(employe!=null)
		{
			employe.setEmail(email);
			employerRepository.save(employe);
			employer=modelMapper.map(employe,EmployerDTO.class);
			return employer;
		}
		return employer;
	}

	@Override
	public EmployerDTO updateCompany(Long id,String companyName ) {
		Employer employe=employerRepository.findById(id).orElse(null);
		EmployerDTO employer=null;
		if(employe!=null)
		{
			employe.setCompanyName(companyName);
			employerRepository.save(employe);
			employer=modelMapper.map(employe,EmployerDTO.class);
			return employer;
		}
		return employer;
	}

	@Override
	public EmployerDTO findById(Long id) {
		Employer employe=employerRepository.findById(id).orElse(null);
		EmployerDTO employer=null;
		if(employe!=null)
		{
		employer=modelMapper.map(employe,EmployerDTO.class);
		}
		return employer;
	}

	@Override
	public List<EmployerDTO> findByCompanyName(String name) {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findByCompanyName(name).orElse(null));
		List<EmployerDTO> employer=null;
		if(employers!=null)
		{
		employer=employers.stream().map(employer1->modelMapper.map(employer1, EmployerDTO.class)).collect(Collectors.toList());
		}
		return employer;
	}

	@Override
	public EmployerDTO findByEmail(String email) {
		Employer employe=employerRepository.findByEmail(email).orElse(null);
		EmployerDTO employer=null;
		if(employe!=null)
		{
		employer=modelMapper.map(employe,EmployerDTO.class);
		}
		return employer;
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
	public List<EmployerDTO> deleteAll() {
		List<Employer> employer=employerRepository.findAll();
		List<EmployerDTO> employers=null;
		if(employer!=null)
		{
			employerRepository.deleteAll();
			employers=employer.stream().map(employer1->modelMapper.map(employer1, EmployerDTO.class)).collect(Collectors.toList());
		}
		
		return employers;

	}

	@Override
	public long count() {
		Long count=employerRepository.count();
		return count;
	}

	@Override
	public void deleteAll(List<EmployerDTO> employer) {
		List<Employer> employers=employer.stream().map(employer1->modelMapper.map(employer1, Employer.class)).collect(Collectors.toList());
		employers.addAll(employerRepository.findAllEmployers(employers));
		if(employers!=null)
		{
			employerRepository.deleteAll(employers);
		}

	}

	@Override
	public List<EmployerDTO> findAll() {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findAll());
		List<EmployerDTO> employer=null;
		if(employers!=null)
		{
		employer=employers.stream().map(employer1->modelMapper.map(employer1, EmployerDTO.class)).collect(Collectors.toList());
		}
		return employer;	}

	@Override
	public List<Employer> findAll(List<Employer> employers) {
		List<Employer> employer=new ArrayList<>();
		employer.addAll(employerRepository.findAllEmployers(employers));
		return employer;
	}

	@Override
	public List<EmployerDTO> findByFullName(String fullName) {
		List<Employer> employers=new ArrayList<>();
		employers.addAll(employerRepository.findByFullName(fullName));
		List<EmployerDTO> employer=null;
		if(employers!=null)
		{
		employer=employers.stream().map(employer1->modelMapper.map(employer1, EmployerDTO.class)).collect(Collectors.toList());
		}
		return employer;	
		}

	@Override
	public EmployerDTO updateEmployer(Long employerId, EmployerDTO employerDTO) {
	    Optional<Employer> optionalEmployer = employerRepository.findById(employerId);
	    EmployerDTO employeDTO=null;
	    if (optionalEmployer.isPresent()) {
	        Employer existingEmployer = optionalEmployer.get();
	        // Update the existing employer with the new information
	        existingEmployer.setFullName(employerDTO.getFullName());
	        existingEmployer.setCompanyName(employerDTO.getCompanyName());
	        existingEmployer.setMobileNo(employerDTO.getMobileNo());
	        existingEmployer.setEmail(employerDTO.getEmail());
	        existingEmployer.setImage(employerDTO.getImage());
	        
	        Employer updatedEmployer = employerRepository.save(existingEmployer);
	        
	        employeDTO=modelMapper.map(updatedEmployer, EmployerDTO.class);
	    }
	    return employeDTO;
	}
	@Override
	public EmployerDTO addJobListing(Long employerId, JobListingDTO jobListingDto) {
		Optional<Employer> optionalEmployer = employerRepository.findById(employerId);
	    EmployerDTO updatedEmployerDTO=null;
	    if (optionalEmployer.isPresent())
	    {
	        Employer existingEmployer = optionalEmployer.get();
	        List<JobListing> list = existingEmployer.getJobListing();
	        JobListing jobListing=modelMapper.map(jobListingDto, JobListing.class);
	        list.add(jobListing);
	        existingEmployer.setJobListing(list);
	        Employer updatedEmployer = employerRepository.save(existingEmployer);
	        updatedEmployerDTO=modelMapper.map(updatedEmployer, EmployerDTO.class);
	    } 
	    return updatedEmployerDTO;
	}

}
