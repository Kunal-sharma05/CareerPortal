package com.hexa.CareerPortal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
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

import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.entity.JobApplication;
import com.hexa.CareerPortal.entity.JobListing;
import com.hexa.CareerPortal.exception.JobNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.JobListingService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jobListings")
public class JobListingController {

    private final JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    @PostMapping //checked
    public ResponseEntity<JobListingDTO> createJobListing(@Valid @RequestBody JobListingDTO jobListingDTO) {
        JobListingDTO createdJobListing = jobListingService.postJob(jobListingDTO);
        return new ResponseEntity<>(createdJobListing, HttpStatus.CREATED);
    }

    @GetMapping("/{jobListingId}")  //checked
    public ResponseEntity<JobListingDTO> getJobListingById(@PathVariable Long jobListingId) throws ResourceNotFoundException {
        JobListingDTO jobListingDTO = jobListingService.findByJobListingId(jobListingId);
        if (jobListingDTO != null) {
            return ResponseEntity.ok(jobListingDTO);
        } else {
            throw new ResourceNotFoundException("Job Listing not found with id: " + jobListingId);
        }
    }

    @PutMapping("/{jobListingId}")  //checked
    public ResponseEntity<JobListingDTO> updateJobListing(@PathVariable Long jobListingId, @Validated @RequestBody JobListingDTO jobListingDTO) throws ResourceNotFoundException {
        JobListingDTO updatedJobListing = jobListingService.updateJobListing(jobListingId, jobListingDTO);
        if (updatedJobListing != null) {
            return ResponseEntity.ok(updatedJobListing);
        } else {
            throw new ResourceNotFoundException("Job Listing not found with id: " + jobListingId);
        }
    }

    @DeleteMapping("/{jobListingId}")  //checked
    public ResponseEntity<Void> deleteJobListing(@PathVariable Long jobListingId) {
        jobListingService.deleteById(jobListingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping  //checked
    public ResponseEntity<List<JobListingDTO>> getAllJobListings() throws JobNotFoundException {
        List<JobListingDTO> jobListings = jobListingService.findAll();
        if (!jobListings.isEmpty()) {
            return ResponseEntity.ok(jobListings);
        } else {
        	throw new JobNotFoundException("Jobs not found ");
        }
    }
    
    @PostMapping("/createBatch")
    public ResponseEntity<List<JobListingDTO>> postJobs(@RequestBody List<JobListingDTO> jobListingDTOs) {
            List<JobListingDTO> createdJobListingDTOs = jobListingService.postJobs(jobListingDTOs);
            return ResponseEntity.ok(createdJobListingDTOs);
      }

        @PutMapping("/{id}/updateRequirements")
        public ResponseEntity<JobListingDTO> updateRequirements(@PathVariable Long id, @RequestParam String requirements) throws JobNotFoundException {
            JobListingDTO updatedJobListing = jobListingService.updateRequirements(id, requirements);
            if (updatedJobListing != null) {
                return ResponseEntity.ok(updatedJobListing);
            } else {
                throw new JobNotFoundException("Job Listing not found with id: " + id);
            }
        }

        @PutMapping("/{id}/updateDescription")
        public ResponseEntity<JobListingDTO> updateDescription(@PathVariable Long id, @RequestParam String description) throws JobNotFoundException {
        	 JobListingDTO updatedJobListing = jobListingService.updateDescription(id, description);
             if (updatedJobListing != null) {
                 return ResponseEntity.ok(updatedJobListing);
             } else {
                 throw new JobNotFoundException("Job Listing not found with id: " + id);
             }
        }

        @PutMapping("/{id}/updateTitle")
        public ResponseEntity<JobListingDTO> updateTitle(@PathVariable Long id, @RequestParam String title) throws JobNotFoundException {
        	JobListingDTO updatedJobListing = jobListingService.updateTitle(id, title);
            if (updatedJobListing != null) {
                return ResponseEntity.ok(updatedJobListing);
            } else {
                throw new JobNotFoundException("Job Listing not found with id: " + id);
            }        
        }

        @GetMapping("/findByRequirements")
        public ResponseEntity<List<JobListingDTO>> findByRequirements(@RequestParam String requirements) throws JobNotFoundException {
        	List<JobListingDTO> jobListings = jobListingService.findByRequirements(requirements);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByRequirementsContaining")
        public ResponseEntity<List<JobListingDTO>> findByRequirementsContaining(@RequestParam String requirement) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByRequirementsContaining(requirement);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByDescription")
        public ResponseEntity<List<JobListingDTO>> findByDescription(@RequestParam String description) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByDescription(description);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByDescriptionContaining")
        public ResponseEntity<List<JobListingDTO>> findByDescriptionContaining(@RequestParam String description) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByDescriptionContaining(description);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByTitle")
        public ResponseEntity<List<JobListingDTO>> findByTitle(@RequestParam String title) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByTitle(title);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByTitleContaining")
        public ResponseEntity<List<JobListingDTO>> findByTitleContaining(@RequestParam String title) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByTitleContaining(title);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @GetMapping("/findByDate")
        public ResponseEntity<List<JobListingDTO>> findByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByDate(date);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<List<JobListingDTO>> deleteAll() throws JobNotFoundException {
            List<JobListingDTO> deletedJobListings = jobListingService.deleteAll();
            if (!deletedJobListings.isEmpty()) {
                return ResponseEntity.ok(deletedJobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }        
        }

        @GetMapping("/count")
        public ResponseEntity<Long> count() {
            long jobListingCount = jobListingService.count();
            return ResponseEntity.ok(jobListingCount);
        }

        @DeleteMapping("/deleteAllBatch")
        public ResponseEntity<List<JobListingDTO>> deleteAllBatch(@RequestBody List<JobListing> jobListings) {
            List<JobListingDTO> deletedJobListings = jobListingService.deleteAll(jobListings);
            return ResponseEntity.ok(deletedJobListings);
        }

        @GetMapping("/findAll")
        public ResponseEntity<List<JobListingDTO>> findAll() throws JobNotFoundException {
            List<JobListingDTO> allJobListingDTOs = jobListingService.findAll();
            if (!allJobListingDTOs.isEmpty()) {
                return ResponseEntity.ok(allJobListingDTOs);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            } 
        }
        @GetMapping("/searchByTitleAndRequirement")
        public ResponseEntity<List<JobListingDTO>> findByTitleAndRequirement(@RequestParam String title, @RequestParam String requirements) throws JobNotFoundException {
            List<JobListingDTO> jobListings = jobListingService.findByTitleAndRequirementsContaining(title, requirements);
            if (!jobListings.isEmpty()) {
                return ResponseEntity.ok(jobListings);
            } else {
            	throw new JobNotFoundException("Jobs not found ");
            }
         
        }
        @PutMapping("/{id}/addJobApplication")
        public ResponseEntity<JobListingDTO> addJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) throws JobNotFoundException {
       	 JobListingDTO updatedJobListing = jobListingService.addingJobApplication(id, jobApplication);
            if (updatedJobListing != null) {
                return ResponseEntity.ok(updatedJobListing);
            } else {
                throw new JobNotFoundException("Job Listing not found with id: " + id);
            }
       }
        
        @PutMapping("/{id}/updateJobApplication")
        public ResponseEntity<JobListingDTO> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) throws JobNotFoundException {
       	 JobListingDTO updatedJobListing = jobListingService.updatingJobApplication(id, jobApplication);
            if (updatedJobListing != null) {
                return ResponseEntity.ok(updatedJobListing);
            } else {
                throw new JobNotFoundException("Job Listing not found with id: " + id);
            }
       }
        
       
        
        

    
}
