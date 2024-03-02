package com.hexa.CareerPortal.dto;

public class ResumeDTO {

	private Long resumeId;
    private String fileUrl;
	public ResumeDTO(Long resumeId, String fileUrl) {
		super();
		this.resumeId = resumeId;
		this.fileUrl = fileUrl;
	
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
	

	@Override
	public String toString() {
		return "ResumeDTO [resumeId "+resumeId +", fileUrl=" + fileUrl
				+  "]";
	}
  
}
