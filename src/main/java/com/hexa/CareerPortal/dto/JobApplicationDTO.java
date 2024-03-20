package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;

import jakarta.validation.constraints.NotNull;

public class JobApplicationDTO {
	
	private Long jobApplicationId;
	@NotNull(message = "status should not be empty")
    private Status status;
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
	public JobApplicationDTO(@NotNull(message = "status should not be empty") Status status) {
		super();
		this.status = status;
	}
	public JobApplicationDTO() {
		super();
		
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
	
	public Long getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	
	
	@Override
	public String toString() {
		return "JobApplicationDTO [jobApplicationId=" + jobApplicationId + ", status=" + status + ", id=" + id
				+ ", jobSeekerId=" + jobSeekerId + "]";
	}
	public JobApplicationDTO(Long jobApplicationId, @NotNull(message = "status should not be empty") Status status) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
	}
	public JobApplicationDTO(Long jobApplicationId, @NotNull(message = "status should not be empty") Status status,
			Long id) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
		this.id = id;
	}
	public JobApplicationDTO(Long jobApplicationId, @NotNull(message = "status should not be empty") Status status,
			Long id, Long jobSeekerId) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
		this.id = id;
		this.jobSeekerId = jobSeekerId;
	}



    
}