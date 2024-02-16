package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
	private String password;

    @NotNull(message = "Role should not be null")
    private Role role;

    private EmployerDTO employer;
    private JobSeekerDTO jobSeeker;
    public UserDTO() {
    }

    public UserDTO(
			 String name,String email,String password, Role role, EmployerDTO employer, JobSeekerDTO jobSeeker) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.employer = employer;
		this.jobSeeker = jobSeeker;
	}

	public UserDTO(String name, String email,String password, Role role) {
    this.name = name;
    this.email = email;
    this.password=password;
    this.role = role;
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

    public Role getRole() {
    return role;
    }

    public void setRole(Role role) {
    this.role = role;
    }

    public EmployerDTO getEmployer() {
    return employer;
    }

    public void setEmployer(EmployerDTO employer) {
    this.employer = employer;
    }

    public JobSeekerDTO getJobSeeker() {
    return jobSeeker;
    }

    public void setJobSeeker(JobSeekerDTO jobSeeker) {
    this.jobSeeker = jobSeeker;
    }

    }



