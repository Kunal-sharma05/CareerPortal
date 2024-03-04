package com.hexa.CareerPortal.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Status;
import com.hexa.CareerPortal.exception.JobApplicationNotFoundException;
import com.hexa.CareerPortal.service.JobApplicationService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jobapplications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;


    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping  //checked
    public ResponseEntity<JobApplicationDTO> createJobApplication(@Valid @RequestBody JobApplicationDTO jobApplicationDTO) {
        JobApplicationDTO createdJobApplication = jobApplicationService.createJobApplication(jobApplicationDTO);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/{jobApplicationId}")  //checked
    public ResponseEntity<JobApplicationDTO> getJobApplicationById(@PathVariable Long jobApplicationId) throws JobApplicationNotFoundException {
       
            JobApplicationDTO jobApplicationDTO = jobApplicationService.findByJobApplicationId(jobApplicationId);
            if (jobApplicationDTO != null) {
                return new ResponseEntity<>(jobApplicationDTO, HttpStatus.OK);
            } else {
            	throw new JobApplicationNotFoundException("jobApplication not found with id " + jobApplicationId);

            }
    }

    @PutMapping("/{jobApplicationId}")  //checked
    public ResponseEntity<JobApplicationDTO> updateJobApplication(@PathVariable Long jobApplicationId, @Validated @RequestBody JobApplicationDTO jobApplicationDTO) throws  JobApplicationNotFoundException {
       
            JobApplicationDTO updatedJobApplication = jobApplicationService.updateJobApplication(jobApplicationId, jobApplicationDTO);
        if (jobApplicationDTO != null) {  
            return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
        } else {
        	throw new JobApplicationNotFoundException("jobApplication not found with id " + jobApplicationId);

        }
    }

    @DeleteMapping("/{jobApplicationId}")  //checked
    public ResponseEntity<Void> deleteJobApplicationById(@PathVariable Long jobApplicationId) {
        jobApplicationService.deleteById(jobApplicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping  //checked
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
    public ResponseEntity<Void> deleteAllJobApplications() {
    	jobApplicationService.deleteAll();
        
    	return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/updateStatus")
    public ResponseEntity<JobApplicationDTO> updateStatus(@PathVariable Long id, @RequestParam Status status) throws JobApplicationNotFoundException {
   	 JobApplicationDTO updatedjobApplicationDTO = jobApplicationService.updateStatus(id, status);
        if(updatedjobApplicationDTO!=null) {
            return ResponseEntity.ok(updatedjobApplicationDTO);
         }
         else
         {
    	   throw new JobApplicationNotFoundException("jobApplication not found ");
         }
    }
    @PutMapping("/{employerId}/updateMobile")
    public ResponseEntity<JobApplicationDTO> updateMobileNo(@PathVariable Long jobApplicationId, @RequestParam String mobileNo) throws JobApplicationNotFoundException {
   	 JobApplicationDTO updatedMobileNo = jobApplicationService.updatemobileNo(jobApplicationId, mobileNo);
        if(updatedMobileNo!=null) {
            return ResponseEntity.ok(updatedMobileNo);
        }
         else
         {
    	   throw new JobApplicationNotFoundException("Job Application not found ");
         }
       } 
    @PostMapping("/createMultipleJobApplications")
    public ResponseEntity<List<JobApplicationDTO>> createJobApplication(@Valid @RequestBody List<JobApplicationDTO> jobApplications)
    {
    	 List<JobApplicationDTO> createdUsers = jobApplicationService.createJobApplication(jobApplications);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }
}