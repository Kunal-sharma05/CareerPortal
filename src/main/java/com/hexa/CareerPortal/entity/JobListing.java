package com.hexa.CareerPortal.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jobListing")
public class JobListing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_listing_id")
	private Long jobListingId;
	private String requirements;
	private String description;
	private String title;
	@CreationTimestamp
	@Column(name="date_of_posting")
	private LocalDateTime dateOfPosting;
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	public JobListing() {
		super();
	}
	public JobListing(Long jobListingId, String requirements, String description, String title,
			LocalDateTime dateOfPosting, Employer employer) {
		super();
		this.jobListingId = jobListingId;
		this.requirements = requirements;
		this.description = description;
		this.title = title;
		this.dateOfPosting = dateOfPosting;
		this.employer = employer;
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
	public LocalDateTime getDateOfPosting() {
		return dateOfPosting;
	}
	public void setDateOfPosting(LocalDateTime dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	@Override
	public String toString() {
		return "JobListing [jobListingId=" + jobListingId + ", requirements=" + requirements + ", description="
				+ description + ", title=" + title + ", dateOfPosting=" + dateOfPosting + ", employer=" + employer
				+ "]";
	}
	
}
