package com.hexa.CareerPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hexa.CareerPortal.dto.JobSeekerDTO;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobSeekerService;

import java.util.List;

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
        JobSeekerDTO jobSeeker = jobSeekerService.findByUserId(id);
        if (jobSeeker != null) {
            return new ResponseEntity<>(jobSeeker, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<JobSeekerDTO>> getAllJobSeekers() throws ResourceNotFoundException {
        List<JobSeekerDTO> jobSeekers = jobSeekerService.findAll();
        if (jobSeekers != null) {
            return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Users not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerDTO> updateJobSeeker(@PathVariable Long id, @RequestBody @Validated JobSeekerDTO jobSeekerDto) throws ResourceNotFoundException {
        JobSeekerDTO updatedJobSeeker = jobSeekerService.updateJobSeeker(id, jobSeekerDto);
        if (updatedJobSeeker != null) {
            return new ResponseEntity<>(updatedJobSeeker, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
