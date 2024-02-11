package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	public Optional<Employer> findById(Long id);
	public Optional<List<Employer>> findByCompanyName(String Name);
	public Optional<Employer> findByEmail(String email);
	public void deleteById(Long id);
	public void deleteAll();
	public long count();
	public void deleteAll(List<Employer> employer);
	public List<Employer> findAll();
	public Optional<List<Employer>> findAll(List<Employer> employers);
}
