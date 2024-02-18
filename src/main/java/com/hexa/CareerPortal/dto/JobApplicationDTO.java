package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.JobSeeker;
import com.hexa.CareerPortal.entity.Status;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class JobApplicationDTO {
	
	@NotNull(message = "status should not be empty")
    private Status status;
	private JobSeeker jobSeeker;
    
	public JobApplicationDTO(@NotNull(message = "status should not be empty") Status status, JobSeeker jobSeeker) {
		super();
		this.status = status;
		this.jobSeeker = jobSeeker;
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

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}


    
}