package com.hexa.CareerPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	public void createUser(User user);
	public List<User> createUsers(List<User> user);
	public Optional<User> findByName(String name);
	public List<User> findAll();
	public List<User> findAll(List<User> users);
	public Optional<User> findByUserId(Long id);
	public Optional<User> findByEmail(String email);
	public List<User> findByRole(Role role);
	public List<User> findByNameContaining(String name);
	public List<User> findByNameIn(List<String> name);
	public void deleteById(Long id);
	public void deleteAll();
	public long count();
	public void deleteAll(List<User> user);
}
