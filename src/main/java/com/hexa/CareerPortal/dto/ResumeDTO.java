package com.hexa.CareerPortal.dto;

import java.time.LocalDateTime;
public class ResumeDTO {

    private Long resumeId;
    private String fileUrl;
    private LocalDateTime updateDate;
	public ResumeDTO(Long resumeId, String fileUrl, LocalDateTime updateDate) {
		super();
		this.resumeId = resumeId;
		this.fileUrl = fileUrl;
		this.updateDate = updateDate;
	}
	public ResumeDTO() {
		super();
		// TODO Auto-generated constructor stub
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
  
}
