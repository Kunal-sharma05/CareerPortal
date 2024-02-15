package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	public Optional<List<Employer>> findByCompanyName(String Name);
	public Optional<Employer> findByEmail(String email);
	@Query("DELETE FROM Employer e " +
	           "WHERE e.companyName = :#{#employer.companyName} " +
	           "AND e.mobileNo = :#{#employer.mobileNo} " +
	           "AND e.email = :#{#employer.email}")
	    @Modifying
	  public  void deleteAll(List<Employer> employer);

	@Query("SELECT e FROM Employer e " +
	           "WHERE e.companyName = :#{#employer.companyName} " +
	           "AND e.mobileNo = :#{#employer.mobileNo} " +
	           "AND e.email = :#{#employer.email}")
	    List<Employer> findAllEmployers(@Param("employer") List<Employer> employers);
	public List<Employer> findByFullName(String fullName);
}
