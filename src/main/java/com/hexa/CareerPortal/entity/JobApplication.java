package com.hexa.CareerPortal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job_application")
public class JobApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_application_id")
	private Long jobApplicationId;
	private Status status;
	@CreationTimestamp
	@Column(name="application_date")
	private LocalDateTime applicationDate;
	@UpdateTimestamp
	@Column(name="application_updated_date")
	private LocalDateTime applicationUpadtedDate;
	private Long id;
	private Long jobSeekerId;
	public Long getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public JobApplication() {
		super();
	}
	public JobApplication(Long jobApplicationId, Status status, LocalDateTime applicationDate,
			LocalDateTime applicationUpadtedDate) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
		this.applicationDate = applicationDate;
		this.applicationUpadtedDate = applicationUpadtedDate;
		
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
		if(status==null)
		{
			this.status=Status.PENDING;
		}
		else {
		this.status = status;
		}
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
	

	@Override
	public String toString() {
		return "JobApplication [jobApplicationId=" + jobApplicationId + ", status=" + status + ", applicationDate="
				+ applicationDate + ", applicationUpadtedDate=" + applicationUpadtedDate + ", id=" + id
				+ ", jobSeekerId=" + jobSeekerId + "]";
	}
	public void setMobileNo(String mobileNo) {
		
		
	}
	public JobApplication(Long jobApplicationId, Status status, LocalDateTime applicationDate,
			LocalDateTime applicationUpadtedDate, Long id, Long jobSeekerId) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
		this.applicationDate = applicationDate;
		this.applicationUpadtedDate = applicationUpadtedDate;
		this.id = id;
		this.jobSeekerId = jobSeekerId;
	}
	
	
}