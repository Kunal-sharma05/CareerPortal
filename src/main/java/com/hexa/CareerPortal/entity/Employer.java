package com.hexa.CareerPortal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="employer_details")
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id")
	private Long employerId;
	@Column(name="full_name")
	private String fullName;
	@Column(name="company_name")
	private String companyName;
	@Column(name="mobile_number")
	private String mobileNo;
	@Column(unique=true)
	private String email;
	@Column(name="image")
	private String image;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Employer_jobListing_mapping",joinColumns=@JoinColumn(name="employer_id"),inverseJoinColumns=@JoinColumn(name="job_Listing_id"))
	private List<JobListing> jobListing;
	public Employer() {
		super();
	}
	
	public Employer(Long employerId,String fullName, String companyName, String mobileNo, String email, List<JobListing> jobListing) {
		super();
		this.employerId = employerId;
		this.fullName=fullName;
		this.companyName = companyName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.jobListing = jobListing;
	}

	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
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

	public List<JobListing> getJobListing() {
		return jobListing;
	}

	public void setJobListing(List<JobListing> jobListing) {
		this.jobListing = jobListing;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", fullName=" + fullName + ", companyName=" + companyName
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", image=" + image + ", jobListing=" + jobListing
				+ "]";
	}



	
	
	
	
}
