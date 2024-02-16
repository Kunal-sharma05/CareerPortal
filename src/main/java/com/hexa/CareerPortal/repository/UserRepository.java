package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	public Optional<List<User>> findByName(String name);
	public Optional<User> findByUserId(Long id);
	public Optional<User> findByEmail(String email);
	public List<User> findByRole(Role role);
	public List<User> findByNameContaining(String name);
	public List<User> findByNameIn(List<String> name);
}
