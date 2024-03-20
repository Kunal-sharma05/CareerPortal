package com.hexa.CareerPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.dto.JobApplicationDTO;
import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.exception.JobSeekerNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobSeekerService;
import com.hexa.CareerPortal.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	@Autowired
    private final JobSeekerService jobSeekerService;
	
	@Autowired
    private final UserService userService;
   
    public JobSeekerController(JobSeekerService jobSeekerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.userService = userService;
    }

    @PostMapping //checked
    public ResponseEntity<JobSeekerDTO> createJobSeeker(@RequestBody @Validated JobSeekerDTO jobSeekerDto) {
    	System.out.println("Control in create job seeker");
        JobSeekerDTO createdJobSeeker = jobSeekerService.createJobSeeker(jobSeekerDto);
        return new ResponseEntity<>(createdJobSeeker, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") //checked
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

    @GetMapping("/getAllJobSeekers") //checked
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

    @PutMapping("/{id}") //checked
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
    @DeleteMapping("/{id}")  //checked
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
    @PutMapping("/{employerId}/updateMobile") //checked
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
    @GetMapping("/searchByDetails")
    public ResponseEntity<List<JobSeekerDTO>> findByDetails(@RequestParam String details) throws JobSeekerNotFoundException {
        List<JobSeekerDTO> jobSeekerDTO=jobSeekerService.findByProfessionalDetailsOrEducationDetailContaining(details);
        if(!jobSeekerDTO.isEmpty())
        {
        	return ResponseEntity.ok(jobSeekerDTO); 
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with details: " + details);
        }
    }
    @PutMapping ("/addProfile/{id}")
    public ResponseEntity<UserDTO> addJobSeekerProfile(@PathVariable Long id ,@Valid @RequestBody JobSeekerDTO jobSeekerDTO) throws ResourceNotFoundException {
		UserDTO createdUser = userService.addJobSeeker(id, jobSeekerDTO);
        if(createdUser!=null) {
        	return ResponseEntity.ok(createdUser);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }

    }
    @PutMapping("/addJobApplication/{id}/{jobId}")
    public ResponseEntity<JobSeekerDTO> addJobApplication(@PathVariable Long id,@PathVariable Long jobId, @RequestBody JobApplicationDTO jobApplicationDTO) throws JobSeekerNotFoundException {
    	JobSeekerDTO jobSeekerDTO= jobSeekerService.addJobApplication(id, jobApplicationDTO, jobId);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
    }
    @PutMapping("/addResume/{id}")
    public ResponseEntity<JobSeekerDTO> addResume(@PathVariable Long id, @RequestBody ResumeDTO resumeDTO) throws JobSeekerNotFoundException {
    	JobSeekerDTO jobSeekerDTO= jobSeekerService.addResume(id, resumeDTO);
        if(jobSeekerDTO!=null) {
        	return ResponseEntity.ok(jobSeekerDTO);
        }
        else
        {
        	throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
    }
    
    
}
