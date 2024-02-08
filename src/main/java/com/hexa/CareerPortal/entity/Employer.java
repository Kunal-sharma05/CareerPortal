package com.hexa.CareerPortal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employer")
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employerId;
	private String companyName;
	private String mobileNo;
	private String email;
	public Employer() {
		super();
	}
	public Employer(Long employerId, String companyName, String mobileNo, String email) {
		super();
		this.employerId = employerId;
		this.companyName = companyName;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
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
	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", companyName=" + companyName + ", mobileNo=" + mobileNo
				+ ", email=" + email + "]";
	}
	

}
