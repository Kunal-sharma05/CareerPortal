package com.hexa.CareerPortal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="job_seeker")
public class JobSeeker {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_id")
	private Long jobSeekerId;
	@Column(name="full_name")
	private String fullName;
	@Column(name="professional_details")
	private String professionalDetails;
	@Column(name="education_details")
	private String educationDetail;
	@Column(name="mobile_number")
	private String mobileNumber;
	@Column(unique=true)
	private String email;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime dateUpdated;
	@Column(name="image")
	private String image;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="jobSeeker_jobApplication_mapping",joinColumns=@JoinColumn(name="job_seeker_id"),inverseJoinColumns=@JoinColumn(name="job_application_id"))
	private List<JobApplication> jobApplication=new ArrayList<>();
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinTable(name="jobSeeker_resume_mapping",joinColumns=@JoinColumn(name="job_seeker_id"),inverseJoinColumns=@JoinColumn(name="resume_id"))
	private List<Resume> resumes=new ArrayList<>();
	public JobSeeker() {
		super();
	}


	public Long getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
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
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public List<JobApplication> getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resume) {
		this.resumes = resume;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public JobSeeker(Long jobSeekerId, String fullName, String professionalDetails, String educationDetail,
			String mobileNumber, String email, LocalDate dateOfBirth, LocalDateTime dateCreated, LocalDateTime dateUpdated,
			String image, List<JobApplication> jobApplication, List<Resume> resumes) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.fullName = fullName;
		this.professionalDetails = professionalDetails;
		this.educationDetail = educationDetail;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.image = image;
		this.jobApplication = jobApplication;
		this.resumes = resumes;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "JobSeeker [jobSeekerId=" + jobSeekerId + ", fullName=" + fullName + ", professionalDetails="
				+ professionalDetails + ", educationDetail=" + educationDetail + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", image=" + image + ", jobApplication=" + jobApplication
				+ ", resumes=" + resumes + "]";
	}
	
	
}
