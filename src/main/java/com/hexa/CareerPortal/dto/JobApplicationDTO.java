package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;

import jakarta.validation.constraints.NotNull;

public class JobApplicationDTO {
	
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
		this.status = status;
	}
	@Override
	public String toString() {
		return "JobApplicationDTO [status=" + status + "]";
	}



    
}