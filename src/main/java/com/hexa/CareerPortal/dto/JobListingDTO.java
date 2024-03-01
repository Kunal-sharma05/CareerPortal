package com.hexa.CareerPortal.dto;

import jakarta.validation.constraints.NotEmpty;

public class JobListingDTO {
	
	private Long jobListingId;
    @NotEmpty(message = "Requirements should not be empty")
    private String requirements;

    @NotEmpty(message = "Description should not be empty")
    private String description;

    @NotEmpty(message = "Title should not be empty")
    private String title;
	private JobApplicationDTO jobApplication;

    public JobListingDTO() {
    }

    public JobListingDTO(String requirements, String description, String title) {
        this.requirements = requirements;
        this.description = description;
        this.title = title;
    }
   

	public JobListingDTO(@NotEmpty(message = "Requirements should not be empty") String requirements,
			@NotEmpty(message = "Description should not be empty") String description,
			@NotEmpty(message = "Title should not be empty") String title,
			JobApplicationDTO jobApplication) {
		super();
		this.requirements = requirements;
		this.description = description;
		this.title = title;
		this.jobApplication = jobApplication;
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

	public JobApplicationDTO getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplicationDTO jobApplication) {
		this.jobApplication = jobApplication;
	}

	public Long getJobListingId() {
		return jobListingId;
	}

	public void setJobListingId(Long jobListingId) {
		this.jobListingId = jobListingId;
	}

	@Override
	public String toString() {
		return "JobListingDTO [jobListingId=" + jobListingId + ", requirements=" + requirements + ", description="
				+ description + ", title=" + title + ", jobApplication=" + jobApplication + "]";
	}

	public JobListingDTO(Long jobListingId, @NotEmpty(message = "Requirements should not be empty") String requirements,
			@NotEmpty(message = "Description should not be empty") String description,
			@NotEmpty(message = "Title should not be empty") String title, JobApplicationDTO jobApplication) {
		super();
		this.jobListingId = jobListingId;
		this.requirements = requirements;
		this.description = description;
		this.title = title;
		this.jobApplication = jobApplication;
	}
}
