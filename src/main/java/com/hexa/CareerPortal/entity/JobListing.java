package com.hexa.CareerPortal.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="jobListing")
public class JobListing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_listing_id")
	private Long jobListingId;
	private String image;
	private String requirements;
	private String description;
	private String title;
	@CreationTimestamp
	@Column(name="date_of_posting")
	private LocalDateTime dateOfPosting;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="jobListing_jobApplication_mapping",joinColumns=@JoinColumn(name="job_listing_id"),inverseJoinColumns=@JoinColumn(name="job_application_id"))
	private List<JobApplication> jobApplication=new ArrayList<>();

	public JobListing() {
		super();
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
	public List<JobApplication> getJobApplication() {
		return jobApplication;
	}
	public void addJobApplication(JobApplication jobApplication) {
		this.jobApplication.add(jobApplication);
	}
	public void setJobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}
	@Override
	public String toString() {
		return "JobListing [jobListingId=" + jobListingId + ", image=" + image + ", requirements=" + requirements
				+ ", description=" + description + ", title=" + title + ", dateOfPosting=" + dateOfPosting
				+ ", jobApplication=" + jobApplication + "]";
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public JobListing(Long jobListingId, String image, String requirements, String description, String title,
			LocalDateTime dateOfPosting, List<JobApplication> jobApplication) {
		super();
		this.jobListingId = jobListingId;
		this.image = image;
		this.requirements = requirements;
		this.description = description;
		this.title = title;
		this.dateOfPosting = dateOfPosting;
		this.jobApplication = jobApplication;
	}
	
	
}
