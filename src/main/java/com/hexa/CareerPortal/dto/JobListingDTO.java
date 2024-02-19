package com.hexa.CareerPortal.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.entity.JobApplication;

public class JobListingDTO {
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

	@Override
	public String toString() {
		return "JobListingDTO [requirements=" + requirements + ", description=" + description + ", title=" + title
			 + "]";
	}

	public JobApplicationDTO getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplicationDTO jobApplication) {
		this.jobApplication = jobApplication;
	}
}
