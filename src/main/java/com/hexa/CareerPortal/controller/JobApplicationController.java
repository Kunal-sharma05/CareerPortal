package com.hexa.CareerPortal.controller;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
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
    public ResponseEntity<JobApplicationDTO> getJobApplicationById(@PathVariable Long jobApplicationId) throws ResourceNotFoundException {
       
            JobApplicationDTO jobApplicationDTO = jobApplicationService.findByJobApplicationId(jobApplicationId);
            if (jobApplicationDTO != null) {
                return new ResponseEntity<>(jobApplicationDTO, HttpStatus.OK);
            } else {
                throw new ResourceNotFoundException("User not found with id: " + jobApplicationId);
            }
    }

    @PutMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplicationDTO> updateJobApplication(@PathVariable Long jobApplicationId, @Validated @RequestBody JobApplicationDTO jobApplicationDTO) throws ResourceNotFoundException {
       
            JobApplicationDTO updatedJobApplication = jobApplicationService.updateJobApplication(jobApplicationId, jobApplicationDTO);
        if (jobApplicationDTO != null) {  
            return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + jobApplicationId);
        }
    }

    @DeleteMapping("/{jobApplicationId}")
    public ResponseEntity<Void> deleteJobApplicationById(@PathVariable Long jobApplicationId) {
        jobApplicationService.deleteById(jobApplicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobApplicationDTO>> getAllJobApplications() {
        List<JobApplicationDTO> jobApplications = jobApplicationService.findAll();
        return ResponseEntity.ok(jobApplications);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        long count= jobApplicationService.count();
        return ResponseEntity.ok(count);
        
    }
    
    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<JobApplicationDTO>> deleteAllJobApplications() throws ResourceNotFoundException {
    	List<JobApplicationDTO> userDTOs=jobApplicationService.deleteAll();
        if(userDTOs!=null) {
        	return ResponseEntity.ok(userDTOs); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    
}