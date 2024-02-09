package com.hexa.CareerPortal.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="resume")
public class Resume {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String resumeId;
	private String fileUrl;
	@CreationTimestamp
	private LocalDateTime uploadDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	public Resume() {
		super();
	}
	public Resume(String resumeId, String fileUrl, LocalDateTime uploadDate, LocalDateTime updateDate,
			JobSeeker jobSeeker) {
		super();
		this.resumeId = resumeId;
		this.fileUrl = fileUrl;
		this.uploadDate = uploadDate;
		this.updateDate = updateDate;
		this.jobSeeker = jobSeeker;
	}
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public LocalDateTime getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", fileUrl=" + fileUrl + ", uploadDate=" + uploadDate + ", updateDate="
				+ updateDate + ", jobSeeker=" + jobSeeker + "]";
	} 
	
	
}