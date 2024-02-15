package com.hexa.CareerPortal.dto;

import com.hexa.CareerPortal.entity.Status;
import java.time.LocalDateTime;

public class JobApplicationDTO {
 
    private Status status;
    private LocalDateTime applicationUpdatedDate;
    
<<<<<<< HEAD
	public JobApplicationDTO(Status status, LocalDateTime applicationUpdatedDate) {
		super();
		this.status = status;
		
		this.applicationUpdatedDate = applicationUpdatedDate;
=======
	public JobApplicationDTO(Status status,LocalDateTime applicationUpdatedDate) {
		super();
		this.status = status;
		this.applicationUpdatedDate=applicationUpdatedDate;
>>>>>>> a2ece5ec8b0e24eef5ffd59fbba220bdb0ab3a0d
		
	}
	public JobApplicationDTO() {
		super();
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
=======
>>>>>>> a2ece5ec8b0e24eef5ffd59fbba220bdb0ab3a0d
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
<<<<<<< HEAD
		return "JobApplicationDTO [status=" + status + ", applicationDate="
=======
		return "JobApplicationDTO [status=" + status
>>>>>>> a2ece5ec8b0e24eef5ffd59fbba220bdb0ab3a0d
				+ ", applicationUpdatedDate=" + applicationUpdatedDate + "]";
	}
    
}