package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class JobApplicationDTO {
	
	private Long jobApplicationId;
	
	@NotNull(message = "status should not be empty")
    private Status status;
	    
	public JobApplicationDTO(Long jobApplicationId,
			@NotNull(message = "status should not be empty") Status status) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.status = status;
	}
	public JobApplicationDTO() {
		super();
		
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
	@Override
	public String toString() {
		return "JobApplicationDTO [jobApplicationId"+ jobApplicationId+", status=" + status + "]";
	}



    
}