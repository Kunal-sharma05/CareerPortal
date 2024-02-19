package com.hexa.CareerPortal.dto;

public class ResumeDTO {

    private String fileUrl;
	public ResumeDTO( String fileUrl) {
		super();
		this.fileUrl = fileUrl;
	
	}
	
	
	
	public ResumeDTO() {
		super();
	}

	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	

	@Override
	public String toString() {
		return "ResumeDTO [ fileUrl=" + fileUrl
				+  "]";
	}
  
}
