package com.hexa.CareerPortal.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
public class ResumeDTO {

	@NotNull(message = "id should not be empty")
    private Long resumeId;
	@NotNull(message = "url should not be empty")
    private String fileUrl;
	@NotNull(message = "updated date can be empty")
	@FutureOrPresent(message = "Date should be either future or present")
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
