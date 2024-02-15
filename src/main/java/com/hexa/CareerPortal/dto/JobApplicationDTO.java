package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class JobApplicationDTO {
	
	@NotNull(message = "status should not be empty")
    private Status status;
	@NotNull(message = "updated date can be empty")
	@FutureOrPresent(message = "Date should be either future or present")
    private LocalDateTime applicationUpdatedDate;
    
	public JobApplicationDTO(Status status,LocalDateTime applicationUpdatedDate) {
		super();
		this.status = status;
		this.applicationUpdatedDate=applicationUpdatedDate;
		
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
	public LocalDateTime getApplicationUpdatedDate() {
		return applicationUpdatedDate;
	}
	public void setApplicationUpdatedDate(LocalDateTime applicationUpdatedDate) {
		this.applicationUpdatedDate = applicationUpdatedDate;
	}
	@Override
	public String toString() {
		return "JobApplicationDTO [status=" + status
				+ ", applicationUpdatedDate=" + applicationUpdatedDate + "]";
	}
    
}