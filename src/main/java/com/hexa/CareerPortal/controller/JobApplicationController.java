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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.exception.JobApplicationNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobApplicationService;

@RestController
@RequestMapping("/api/jobapplications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;


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
    @PutMapping("/{employerId}/updateMobile")
    public ResponseEntity<JobApplicationDTO> updateMobileNo(@PathVariable Long jobApplicationId, @RequestParam String mobileNo) throws JobApplicationNotFoundException {
   	 JobApplicationDTO updatedMobileNo = jobApplicationService.updateMobileNo(jobApplicationId, mobileNo);
        if(updatedMobileNo!=null) {
            return ResponseEntity.ok(updatedMobileNo);
         }
         else
         {
    	   throw new JobApplicationNotFoundException("Job Application not found ");
         }
       }
    
}