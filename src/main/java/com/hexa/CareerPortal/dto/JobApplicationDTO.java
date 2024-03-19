package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;

import jakarta.validation.constraints.NotNull;

public class JobApplicationDTO {
	
	private Long jobApplicationId;
	@NotNull(message = "status should not be empty")
    private Status status;
	    
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
		return "JobApplicationDTO [jobApplicationId=" + jobApplicationId + ", status=" + status + "]";
	}
	public JobApplicationDTO(Long jobApplicationId, @NotNull(message = "status should not be empty") Status status) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
	}



    
}