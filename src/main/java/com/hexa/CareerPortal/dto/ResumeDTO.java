package com.hexa.CareerPortal.dto;


import com.hexa.CareerPortal.entity.JobSeeker;

public class ResumeDTO {

    private String fileUrl;
	public ResumeDTO( String fileUrl, JobSeeker jobSeeker) {
		super();
		this.fileUrl = fileUrl;
		this.jobSeeker = jobSeeker;
	}
	private JobSeeker jobSeeker;
	
	
	public ResumeDTO() {
		super();
	}

	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	@Override
	public String toString() {
		return "ResumeDTO [ fileUrl=" + fileUrl
				+ ", jobSeeker=" + jobSeeker +  "]";
	}
  
}
