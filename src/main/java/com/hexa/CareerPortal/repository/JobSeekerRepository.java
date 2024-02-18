package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.dto.JobSeekerDTO;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeekerDTO, Long>   {

	public List<JobSeekerDTO> findByFullName(String name);
	//public List<JobSeeker> findAll();
	//Opublic JobSeeker findByUserId(Long id);
	public JobSeekerDTO findByEmail(String Email);
	//public JobSeeker deleteByID(Long jobSeekerId);
	public void deleteAll();
	public long count();
	//public void deleteAll(List<JobSeeker> jobseekers);
	//public List<JobSeeker> findAll(List<JobSeeker> jobseekers);
	public JobSeekerDTO save(JobSeekerDTO userEntity);
	public Optional<JobSeekerDTO> findByJobSeekerId(Long id);
}
