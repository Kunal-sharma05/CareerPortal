package com.hexa.CareerPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.exception.JobSeekerNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobSeekerService;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	@Autowired
    private final JobSeekerService jobSeekerService;

   
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping
    public ResponseEntity<JobSeekerDTO> createJobSeeker(@RequestBody @Validated JobSeekerDTO jobSeekerDto) {
        JobSeekerDTO createdJobSeeker = jobSeekerService.createJobSeeker(jobSeekerDto);
        return new ResponseEntity<>(createdJobSeeker, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerDTO> getJobSeekerById(@PathVariable Long id) throws ResourceNotFoundException {
        JobSeekerDTO jobSeeker = jobSeekerService.findByJobSeekerId(id);
        if (jobSeeker != null)
        {
            return new ResponseEntity<>(jobSeeker, HttpStatus.OK);
        }
        else 
        {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<JobSeekerDTO>> getAllJobSeekers() throws ResourceNotFoundException {
        List<JobSeekerDTO> jobSeekers = jobSeekerService.findAll();
        if (jobSeekers != null)
        {
            return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
        }
        else 
        {
            throw new ResourceNotFoundException("Users not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerDTO> updateJobSeeker(@PathVariable Long id, @RequestBody @Validated JobSeekerDTO jobSeekerDto) throws ResourceNotFoundException {
        JobSeekerDTO updatedJobSeeker = jobSeekerService.updateJobSeeker(id, jobSeekerDto);
        if (updatedJobSeeker != null) 
        {
            return new ResponseEntity<>(updatedJobSeeker, HttpStatus.OK);
        } 
        else 
        {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @PutMapping("/updateName/{id}")
    public ResponseEntity<JobSeekerDTO> updateName(@PathVariable Long id, @RequestBody String name) throws ResourceNotFoundException {
    	JobSeekerDTO jobSeekerDTO=jobSeekerService.updateName(id, name);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }

    }
    @PutMapping("/updateEmail/{id}")
    public ResponseEntity<JobSeekerDTO> updateEmail(@PathVariable Long id, @RequestBody String email) throws ResourceNotFoundException {
    	JobSeekerDTO jobSeekerDTO= jobSeekerService.updateEmail(id, email);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeekerById(@PathVariable Long id) {
        jobSeekerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findByName")
    public ResponseEntity<List<JobSeekerDTO>> findByName(@RequestParam String name) throws ResourceNotFoundException {
        List<JobSeekerDTO> jobSeekerDTO=jobSeekerService.findByName(name);
        if(jobSeekerDTO!=null)
        {
        	return ResponseEntity.ok(jobSeekerDTO); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }
    
    @GetMapping("/findByEmail")
    public ResponseEntity<JobSeekerDTO> findByEmail(@RequestParam String email) throws ResourceNotFoundException {
        JobSeekerDTO jobSeeker=jobSeekerService.findByEmail(email);
        if(jobSeeker!=null)
        {
        	return ResponseEntity.ok(jobSeeker); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long userId) throws ResourceNotFoundException {
    	JobSeekerDTO jobSeeker=jobSeekerService.deleteById(userId);
        if(jobSeeker!=null)
        {
        	return ResponseEntity.noContent().build();
        }
        else
        {
        	throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<JobSeekerDTO>> deleteAllJobSeeker() throws ResourceNotFoundException {
    	List<JobSeekerDTO> jobSeekerDTOs=jobSeekerService.deleteAll();
        if(jobSeekerDTOs!=null) {
        	return ResponseEntity.ok(jobSeekerDTOs); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }
    @PutMapping("/{employerId}/updateMobile")
    public ResponseEntity<JobSeekerDTO> updateMobileNo(@PathVariable Long jobSeekerId, @RequestParam String mobileNo) throws JobSeekerNotFoundException {
   	 JobSeekerDTO updatedMobileNo = jobSeekerService.updateMobileNo(jobSeekerId, mobileNo);
        if(updatedMobileNo!=null) {
            return ResponseEntity.ok(updatedMobileNo);
         }
         else
         {
    	   throw new JobSeekerNotFoundException("Job seeker not found ");
         }
       }
    
}
