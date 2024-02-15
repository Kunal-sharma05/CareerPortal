package com.hexa.CareerPortal.dto;

import java.util.Date;
import java.util.List;

public class JobSeekerDTO {
    private String fullName;
    private String professionalDetails;
    private String educationDetail;
    private String mobileNumber;
    private Date dateOfBirth;
    private String email;
    private List<ResumeDTO> resumes;

    public JobSeekerDTO() {
    }

    public JobSeekerDTO(String fullName, String professionalDetails, String educationDetail, String mobileNumber,Date dateOfBirth, String email) {
        this.fullName = fullName;
        this.professionalDetails = professionalDetails;
        this.educationDetail = educationDetail;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
   

	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfessionalDetails() {
        return professionalDetails;
    }

    public void setProfessionalDetails(String professionalDetails) {
        this.professionalDetails = professionalDetails;
    }

    public String getEducationDetail() {
        return educationDetail;
    }

    public void setEducationDetail(String educationDetail) {
        this.educationDetail = educationDetail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ResumeDTO> getResumes() {
        return resumes;
    }

    public void setResumes(List<ResumeDTO> resumes) {
        this.resumes = resumes;
    }
    @Override
   	public String toString() {
   		return "JobSeekerDTO [fullName=" + fullName + ", professionalDetails=" + professionalDetails
   				+ ", educationDetail=" + educationDetail + ", mobileNumber=" + mobileNumber + ", dateOfBirth="
   				+ dateOfBirth + ", email=" + email + "]";
   	}
}
