package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	private Long userId;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotEmpty( message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",message="minimum 8 character,One lower case, one uper case,"
    		+ " one number and 1 special character")
	private String password;

    @NotNull(message = "Role should not be null")
    private Role role;

    private EmployerDTO employer;
    private JobSeekerDTO jobSeeker;
    public UserDTO() {
    }

    public UserDTO(
    		
    		Long userId, String name,String email,String password, Role role, EmployerDTO employer, JobSeekerDTO jobSeeker) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.employer = employer;
		this.jobSeeker = jobSeeker;
	}

	public UserDTO(Long userId, String name, String email,String password, Role role) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.password=password;
    this.role = role;
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

	@Override
	public String toString() {
		return "UserDTO [userId "+ userId+", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", employer=" + employer + ", jobSeeker=" + jobSeeker + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    }



