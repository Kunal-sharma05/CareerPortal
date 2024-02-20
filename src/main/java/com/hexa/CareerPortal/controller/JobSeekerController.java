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

    @PostMapping("/createJobSeeker")
    public ResponseEntity<JobSeekerDTO> createJobSeeker(@RequestBody @Validated JobSeekerDTO jobSeekerDto) {
        JobSeekerDTO createdJobSeeker = jobSeekerService.createJobSeeker(jobSeekerDto);
        return new ResponseEntity<>(createdJobSeeker, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerDTO> getJobSeekerById(@PathVariable Long id) throws  JobSeekerNotFoundException {
        JobSeekerDTO jobSeeker = jobSeekerService.findByJobSeekerId(id);
        if (jobSeeker != null)
        {
            return new ResponseEntity<>(jobSeeker, HttpStatus.OK);
        }
        else 
        {
            throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
    }

    @GetMapping("/getAllJobSeekers")
    public ResponseEntity<List<JobSeekerDTO>> getAllJobSeekers() throws JobSeekerNotFoundException {
        List<JobSeekerDTO> jobSeekers = jobSeekerService.findAll();
        if (!jobSeekers.isEmpty())
        {
            return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
        }
        else 
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found ");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerDTO> updateJobSeeker(@PathVariable Long id, @RequestBody @Validated JobSeekerDTO jobSeekerDto) throws ResourceNotFoundException, JobSeekerNotFoundException {
        JobSeekerDTO updatedJobSeeker = jobSeekerService.updateJobSeeker(id, jobSeekerDto);
        if (updatedJobSeeker != null) 
        {
            return new ResponseEntity<>(updatedJobSeeker, HttpStatus.OK);
        } 
        else 
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
    }

    @PutMapping("/updateName/{id}")
    public ResponseEntity<JobSeekerDTO> updateName(@PathVariable Long id, @RequestBody String name) throws JobSeekerNotFoundException {
    	JobSeekerDTO jobSeekerDTO=jobSeekerService.updateName(id, name);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }

    }
    @PutMapping("/updateEmail/{id}")
    public ResponseEntity<JobSeekerDTO> updateEmail(@PathVariable Long id, @RequestBody String email) throws JobSeekerNotFoundException {
    	JobSeekerDTO jobSeekerDTO= jobSeekerService.updateEmail(id, email);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeekerById(@PathVariable Long id) {
        jobSeekerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findByName")
    public ResponseEntity<List<JobSeekerDTO>> findByName(@RequestParam String name) throws JobSeekerNotFoundException {
        List<JobSeekerDTO> jobSeekerDTO=jobSeekerService.findByName(name);
        if(!jobSeekerDTO.isEmpty())
        {
        	return ResponseEntity.ok(jobSeekerDTO); 
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with name: " +name);
        }
    }
    
    @GetMapping("/findByEmail")
    public ResponseEntity<JobSeekerDTO> findByEmail(@RequestParam String email) throws JobSeekerNotFoundException {
        JobSeekerDTO jobSeeker=jobSeekerService.findByEmail(email);
        if(jobSeeker!=null)
        {
        	return ResponseEntity.ok(jobSeeker); 
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with email: " +email);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<JobSeekerDTO>> deleteAllJobSeeker() throws ResourceNotFoundException {
    	jobSeekerService.deleteAll();
    	return ResponseEntity.noContent().build();
        
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
