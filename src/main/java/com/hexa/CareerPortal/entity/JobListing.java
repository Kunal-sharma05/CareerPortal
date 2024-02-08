package com.hexa.CareerPortal.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jobListing")
public class JobListing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long jobListingId;
	private String requirements;
	private String description;
	private String title;
	@CreationTimestamp
	private Date dateOfPosting;
	public JobListing() {
		super();
	}
	public JobListing(Long jobListingId, String requirements, String description, String title, Date dateOfPosting) {
		super();
		this.jobListingId = jobListingId;
		this.requirements = requirements;
		this.description = description;
		this.title = title;
		this.dateOfPosting = dateOfPosting;
	}
	public Long getJobListingId() {
		return jobListingId;
	}
	public void setJobListingId(Long jobListingId) {
		this.jobListingId = jobListingId;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateOfPosting() {
		return dateOfPosting;
	}
	public void setDateOfPosting(Date dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}
	@Override
	public String toString() {
		return "JobListing [jobListingId=" + jobListingId + ", Requirements=" + requirements + ", description="
				+ description + ", Title=" + title + ", dateOfPosting=" + dateOfPosting + "]";
	}
	
}
