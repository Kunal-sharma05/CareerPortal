package com.hexa.CareerPortal.dto;

import java.time.LocalDateTime;

public class JobListingDTO {
    private String requirements;
    private String description;
    private String title;
    private LocalDateTime dateOfPosting;
    private EmployerDTO employer;

    public JobListingDTO() {
    }

    public JobListingDTO(String requirements, String description, String title) {
        this.requirements = requirements;
        this.description = description;
        this.title = title;
    }

    // Getters and setters
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
}
