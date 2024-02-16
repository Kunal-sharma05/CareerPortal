package com.hexa.CareerPortal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobListingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobListings")
public class JobListingController {

    private final JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    @PostMapping
    public ResponseEntity<JobListingDTO> createJobListing(@Valid @RequestBody JobListingDTO jobListingDTO) {
        JobListingDTO createdJobListing = jobListingService.postJob(jobListingDTO);
        return new ResponseEntity<>(createdJobListing, HttpStatus.CREATED);
    }

    @GetMapping("/{jobListingId}")
    public ResponseEntity<JobListingDTO> getJobListingById(@PathVariable Long jobListingId) throws ResourceNotFoundException {
        JobListingDTO jobListingDTO = jobListingService.findByJobListingId(jobListingId);
        if (jobListingDTO != null) {
            return ResponseEntity.ok(jobListingDTO);
        } else {
            throw new ResourceNotFoundException("Job Listing not found with id: " + jobListingId);
        }
    }

    @PutMapping("/{jobListingId}")
    public ResponseEntity<JobListingDTO> updateJobListing(@PathVariable Long jobListingId, @Validated @RequestBody JobListingDTO jobListingDTO) throws ResourceNotFoundException {
        JobListingDTO updatedJobListing = jobListingService.updateJobListing(jobListingId, jobListingDTO);
        if (updatedJobListing != null) {
            return ResponseEntity.ok(updatedJobListing);
        } else {
            throw new ResourceNotFoundException("Job Listing not found with id: " + jobListingId);
        }
    }

    @DeleteMapping("/{jobListingId}")
    public ResponseEntity<Void> deleteJobListing(@PathVariable Long jobListingId) {
        jobListingService.deleteById(jobListingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobListingDTO>> getAllJobListings() {
        List<JobListingDTO> jobListings = jobListingService.findAll();
        return ResponseEntity.ok(jobListings);
    }
}
