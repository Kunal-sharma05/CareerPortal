package com.hexa.CareerPortal.dto;

import java.time.LocalDateTime;

import com.hexa.CareerPortal.entity.JobSeeker;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
public class ResumeDTO {

	@NotNull(message = "id should not be empty")
    private Long resumeId;
	@NotNull(message = "url should not be empty")
    private String fileUrl;
	@NotNull(message = "updated date can be empty")
	@FutureOrPresent(message = "Date should be either future or present")
    private LocalDateTime updateDate;
	private JobSeeker jobSeeker;
	private LocalDateTime uploadDate;
	public ResumeDTO(@NotNull(message = "id should not be empty") Long resumeId,
			@NotNull(message = "url should not be empty") String fileUrl,
			@NotNull(message = "updated date can be empty") @FutureOrPresent(message = "Date should be either future or present") LocalDateTime updateDate,
			JobSeeker jobSeeker, LocalDateTime uploadDate) {
		super();
		this.resumeId = resumeId;
		this.fileUrl = fileUrl;
		this.updateDate = updateDate;
		this.jobSeeker = jobSeeker;
		this.uploadDate = uploadDate;
	}
	public ResumeDTO(Long resumeId, String fileUrl, LocalDateTime updateDate) {
		super();
		this.resumeId = resumeId;
		this.fileUrl = fileUrl;
		this.updateDate = updateDate;
	}
	public ResumeDTO() {
		super();
		
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "ResumeDTO [resumeId=" + resumeId + ", fileUrl=" + fileUrl + ", updateDate=" + updateDate + "]";
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	public LocalDateTime getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}
  
}
