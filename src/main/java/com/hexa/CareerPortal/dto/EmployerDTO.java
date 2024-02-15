package com.hexa.CareerPortal.dto;

import java.util.List;

public class EmployerDTO {
    private String fullName;
    private String companyName;
    private String mobileNo;
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
