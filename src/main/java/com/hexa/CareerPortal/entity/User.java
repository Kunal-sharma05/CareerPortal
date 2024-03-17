package com.hexa.CareerPortal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="user_deatils")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	private String name;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Enumerated(value=EnumType.STRING)
	private Role role;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employer_id")
	private Employer employer;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	public User() {
		super();
	}
	public User(Long userId, String name, String email, String password, Role role, Employer employer,
			JobSeeker jobSeeker) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.employer = employer;
		this.jobSeeker = jobSeeker;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", employer=" + employer + ", jobSeeker=" + jobSeeker + "]";
	}
	
}
