package com.hexa.CareerPortal.controller;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.service.JobApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobapplications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public ResponseEntity<JobApplicationDTO> createJobApplication(@Validated @RequestBody JobApplicationDTO jobApplicationDTO) {
        JobApplicationDTO createdJobApplication = jobApplicationService.createJobApplication(jobApplicationDTO);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplicationDTO> getJobApplicationById(@PathVariable Long jobApplicationId) {
        try {
            JobApplicationDTO jobApplicationDTO = jobApplicationService.findByJobApplicationId(jobApplicationId);
            return ResponseEntity.ok(jobApplicationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplicationDTO> updateJobApplication(@PathVariable Long jobApplicationId, @Validated @RequestBody JobApplicationDTO jobApplicationDTO) {
        try {
            JobApplicationDTO updatedJobApplication = jobApplicationService.updateJobApplication(jobApplicationId, jobApplicationDTO);
            return ResponseEntity.ok(updatedJobApplication);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{jobApplicationId}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long jobApplicationId) {
        jobApplicationService.deleteJobApplication(jobApplicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobApplicationDTO>> getAllJobApplications() {
        List<JobApplicationDTO> jobApplications = jobApplicationService.findAll();
        return ResponseEntity.ok(jobApplications);
    }
}