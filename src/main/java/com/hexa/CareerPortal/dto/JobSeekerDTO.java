package com.hexa.CareerPortal.dto;

import java.time.LocalDate;
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
	
	private Long jobSeekerId;
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
    private LocalDate dateOfBirth;
    private String image;
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
			LocalDate dateOfBirth,
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



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public List<JobApplicationDTO> getJobApplication() {
		return jobApplication;
	}



	public void setJobApplication(List<JobApplicationDTO> jobApplication) {
		this.jobApplication = jobApplication;
	}


	public Long getJobSeekerId() {
		return jobSeekerId;
	}



	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "JobSeekerDTO [jobSeekerId=" + jobSeekerId + ", fullName=" + fullName + ", professionalDetails="
				+ professionalDetails + ", educationDetail=" + educationDetail + ", mobileNumber=" + mobileNumber
				+ ", dateOfBirth=" + dateOfBirth + ", image=" + image + ", email=" + email + ", jobApplication="
				+ jobApplication + ", resumes=" + resumes + "]";
	}



	public JobSeekerDTO(Long jobSeekerId,
			@NotEmpty(message = "status should not be empty") @Size(message = "size should not be lesser than 2") String fullName,
			@NotEmpty(message = "details should not be empty") String professionalDetails,
			@NotEmpty(message = "details should not be empty") String educationDetail,
			@NotEmpty(message = "contact number should not be empty") @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits") String mobileNumber,
			LocalDate dateOfBirth, String image,
			@NotEmpty(message = "email should be valid") @Email(message = "email should be valid") String email,
			List<JobApplicationDTO> jobApplication, List<ResumeDTO> resumes) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.fullName = fullName;
		this.professionalDetails = professionalDetails;
		this.educationDetail = educationDetail;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
		this.email = email;
		this.jobApplication = jobApplication;
		this.resumes = resumes;
	}



	
}
