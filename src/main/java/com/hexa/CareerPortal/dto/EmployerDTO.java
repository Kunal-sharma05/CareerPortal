package com.hexa.CareerPortal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

public class EmployerDTO {
    @NotEmpty(message = "Full name should not be empty")
    @Size(min=2,message="Name should be more than 2 letters ")
    private String fullName;

    @NotEmpty(message = "Company name should not be empty")
    private String companyName;

    @NotEmpty(message = "Mobile number should not be empty")
    @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits")
    private String mobileNo;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    private List<JobListingDTO> jobListings;
    public EmployerDTO() {
    }

    public EmployerDTO(String fullName, String companyName, String mobileNo, String email, List<JobListingDTO> jobListings) {
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

    public List<JobListingDTO> getJobListings() {
        return jobListings;
    }

    public void setJobListings(List<JobListingDTO> jobListings) {
        this.jobListings = jobListings;
    }
    @Override
	public String toString() {
		return "EmployerDTO [fullName=" + fullName + ", companyName=" + companyName + ", mobileNo=" + mobileNo
				+ ", email=" + email + "]";
	}
}
