package com.hexa.CareerPortal.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

public class EmployerDTO {
	
	private Long employerId;
    @NotEmpty(message = "Full name should not be empty")
    @Size(min=2,message="Name should be more than 2 letters ")
    private String fullName;
	private String image;
    @NotEmpty(message = "Company name should not be empty")
    private String companyName;

    @NotEmpty(message = "Mobile number should not be empty")
    @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits")
    private String mobileNo;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    private List<JobListingDTO> jobListing;
    public EmployerDTO() {
    }

    public EmployerDTO(String fullName, String companyName, String mobileNo, String email) {
        this.fullName = fullName;
        this.companyName = companyName;
        this.mobileNo = mobileNo;
        this.email = email;
    }


	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<JobListingDTO> getJobListing() {
        return jobListing;
    }

    public void setJobListing(List<JobListingDTO> jobListing) {
        this.jobListing = jobListing;
    }

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "EmployerDTO [employerId=" + employerId + ", fullName=" + fullName + ", image=" + image
				+ ", companyName=" + companyName + ", mobileNo=" + mobileNo + ", email=" + email + ", jobListing="
				+ jobListing + "]";
	}

	public EmployerDTO(Long employerId,
			@NotEmpty(message = "Full name should not be empty") @Size(min = 2, message = "Name should be more than 2 letters ") String fullName,
			String image, @NotEmpty(message = "Company name should not be empty") String companyName,
			@NotEmpty(message = "Mobile number should not be empty") @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits") String mobileNo,
			@NotEmpty(message = "Email should not be empty") @Email(message = "Email should be valid") String email,
			List<JobListingDTO> jobListing) {
		super();
		this.employerId = employerId;
		this.fullName = fullName;
		this.image = image;
		this.companyName = companyName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.jobListing = jobListing;
	}
}
