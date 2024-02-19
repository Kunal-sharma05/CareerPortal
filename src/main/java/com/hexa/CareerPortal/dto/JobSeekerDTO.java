package com.hexa.CareerPortal.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hexa.CareerPortal.entity.JobApplication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class JobSeekerDTO {
	@NotEmpty(message = "status should not be empty")
	@Size(message = "size should not be lesser than 2")
    private String fullName;
	@NotEmpty(message = "details should not be empty")
    private String professionalDetails;
	@NotEmpty(message = "details should not be empty")
    private String educationDetail;
	@NotEmpty(message = "contact number should not be empty")
	@Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits")
    private String mobileNumber;
    private Date dateOfBirth;
	@NotEmpty(message = "email should be valid")
	@Email(message = "email should be valid")
    private String email;
	private List<JobApplicationDTO> jobApplication=new ArrayList<>();
    private List<ResumeDTO> resumes=new ArrayList<>();
    

    public JobSeekerDTO() {
		super();
	}

   

	public JobSeekerDTO(
			@NotEmpty(message = "status should not be empty") @Size(message = "size should not be lesser than 2") String fullName,
			@NotEmpty(message = "details should not be empty") String professionalDetails,
			@NotEmpty(message = "details should not be empty") String educationDetail,
			@NotEmpty(message = "contact number should not be empty") @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits") String mobileNumber,
			Date dateOfBirth,
			@NotEmpty(message = "email should be valid") @Email(message = "email should be valid") String email,
			List<JobApplicationDTO> jobApplication, List<ResumeDTO> resumes) {
		super();
		this.fullName = fullName;
		this.professionalDetails = professionalDetails;
		this.educationDetail = educationDetail;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.jobApplication = jobApplication;
		this.resumes = resumes;
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



	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public List<JobApplicationDTO> getJobApplication() {
		return jobApplication;
	}



	public void setJobApplication(List<JobApplicationDTO> jobApplication) {
		this.jobApplication = jobApplication;
	}



	@Override
	public String toString() {
		return "JobSeekerDTO [fullName=" + fullName + ", professionalDetails=" + professionalDetails
				+ ", educationDetail=" + educationDetail + ", mobileNumber=" + mobileNumber + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", jobApplication=" + jobApplication + ", resumes=" + resumes
				+ "]";
	}

	
}
