package com.hexa.CareerPortal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job_application")
public class JobApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_application_id")
	@OneToOne(mappedBy="job_listing_id")
	private Long jobApplicationId;
	private Status status;
	@CreationTimestamp
	@Column(name="application_date")
	private LocalDateTime applicationDate;
	@UpdateTimestamp
	@Column(name="application_updated_date")
	private LocalDateTime applicationUpadtedDate;
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	public JobApplication() {
		super();
	}
	public JobApplication(Long jobApplicationId, Status status, LocalDateTime applicationDate,
			LocalDateTime applicationUpadtedDate, JobSeeker jobSeeker) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
		this.applicationDate = applicationDate;
		this.applicationUpadtedDate = applicationUpadtedDate;
		this.jobSeeker = jobSeeker;
	}
	public Long getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}
	public LocalDateTime getApplicationUpadtedDate() {
		return applicationUpadtedDate;
	}
	public void setApplicationUpadtedDate(LocalDateTime applicationUpadtedDate) {
		this.applicationUpadtedDate = applicationUpadtedDate;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	@Override
	public String toString() {
		return "JobApplication [jobApplicationId=" + jobApplicationId + ", status=" + status + ", applicationDate="
				+ applicationDate + ", applicationUpadtedDate=" + applicationUpadtedDate + ", jobSeeker=" + jobSeeker
				+ "]";
	}
	
	
}