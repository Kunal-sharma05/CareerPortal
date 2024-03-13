package com.hexa.CareerPortal.dto;

import java.util.List;

import com.hexa.CareerPortal.entity.JobApplication;

import jakarta.validation.constraints.NotEmpty;

public class JobListingDTO {
	
	private Long jobListingId;
    @NotEmpty(message = "Requirements should not be empty")
    private String requirements;
    private String image;
    @NotEmpty(message = "Description should not be empty")
    private String description;

    @NotEmpty(message = "Title should not be empty")
    private String title;
	private List<JobApplication> jobApplication;

    public JobListingDTO() {
    }

    public JobListingDTO(String requirements, String description, String title) {
        this.requirements = requirements;
        this.description = description;
        this.title = title;
    }
   

	public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public Long getJobListingId() {
		return jobListingId;
	}

	public void setJobListingId(Long jobListingId) {
		this.jobListingId = jobListingId;
	}

	public List<JobApplication> getJobApplication() {
		return jobApplication;
	}

	public void addJobApplication(JobApplication jobApplication) {
		this.jobApplication.add(jobApplication);
	}
	public void setJobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public JobListingDTO(Long jobListingId, @NotEmpty(message = "Requirements should not be empty") String requirements,
			String image, @NotEmpty(message = "Description should not be empty") String description,
			@NotEmpty(message = "Title should not be empty") String title, List<JobApplication> jobApplication) {
		super();
		this.jobListingId = jobListingId;
		this.requirements = requirements;
		this.image = image;
		this.description = description;
		this.title = title;
		this.jobApplication = jobApplication;
	}

	@Override
	public String toString() {
		return "JobListingDTO [jobListingId=" + jobListingId + ", requirements=" + requirements + ", image=" + image
				+ ", description=" + description + ", title=" + title + ", jobApplication=" + jobApplication + "]";
	}
}
