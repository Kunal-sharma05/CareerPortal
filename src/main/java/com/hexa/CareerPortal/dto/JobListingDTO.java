package com.hexa.CareerPortal.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public class JobListingDTO {
    @NotEmpty(message = "Requirements should not be empty")
    private String requirements;

    @NotEmpty(message = "Description should not be empty")
    private String description;

    @NotEmpty(message = "Title should not be empty")
    private String title;
    @PastOrPresent(message = "Title should not be empty")
    private LocalDateTime dateOfPosting;
    private EmployerDTO employer;

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

    public LocalDateTime getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(LocalDateTime dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    public EmployerDTO getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDTO employer) {
        this.employer = employer;
    }

	@Override
	public String toString() {
		return "JobListingDTO [requirements=" + requirements + ", description=" + description + ", title=" + title
				+ ", dateOfPosting=" + dateOfPosting + ", employer=" + employer + "]";
	}
}
