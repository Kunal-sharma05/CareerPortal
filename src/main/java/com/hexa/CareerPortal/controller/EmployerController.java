package com.hexa.CareerPortal.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.hexa.CareerPortal.dto.JobListingDTO;
import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.exception.EmployerNotFoundException;
import com.hexa.CareerPortal.exception.JobNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.EmployerService;
import com.hexa.CareerPortal.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private final EmployerService employerService;
    
    private final UserService userService;

    public EmployerController(EmployerService employerService, UserService userService ) {
        this.employerService = employerService;
		this.userService = userService;
    }

    @PostMapping  //checked
    public ResponseEntity<EmployerDTO> createEmployer(@Valid @RequestBody EmployerDTO employerDTO) {
        EmployerDTO createdEmployer = employerService.createEmployer(employerDTO);
        return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
    }

    @GetMapping("/{employerId}")  //checked
    public EntityModel<EmployerDTO> getEmployerById(@PathVariable Long employerId) throws EmployerNotFoundException, JobNotFoundException {
        EmployerDTO employerDTO = employerService.findById(employerId);
        if (employerDTO != null) {
            EntityModel<EmployerDTO> resource = EntityModel.of(employerDTO);
            WebMvcLinkBuilder linkTo = linkTo(methodOn(JobListingController.class).findAll());
            resource.add(linkTo.withRel("all-Jobs"));
            return resource;
        } else {
            throw new EmployerNotFoundException("Employer not found with id: " + employerId);
        }
    }

    @PutMapping("/{employerId}")  //checked
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable Long employerId, @Validated @RequestBody EmployerDTO employerDTO) throws EmployerNotFoundException {
        EmployerDTO updatedEmployer = employerService.updateEmployer(employerId, employerDTO);
        if (updatedEmployer != null) {
            return ResponseEntity.ok(updatedEmployer);
        } else {
        	throw new EmployerNotFoundException("employer not found ");
        }
    }

    @DeleteMapping("delete/{employerId}")  //checked
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long employerId) {
        employerService.deleteById(employerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping  //checked
    public ResponseEntity<List<EmployerDTO>> getAllEmployers() {
        List<EmployerDTO> employers = employerService.findAll();
        return ResponseEntity.ok(employers);
    }

    @PostMapping("/createBatch")
     public ResponseEntity<List<EmployerDTO>> createEmployers(@RequestBody List<EmployerDTO> employerDTOs) {
         List<EmployerDTO> createdEmployerDTOs = employerService.createEmployers(employerDTOs);
         return ResponseEntity.ok(createdEmployerDTOs);
     }

     @PutMapping("/{employerId}/updateMobile")
     public ResponseEntity<EmployerDTO> updateMobileNo(@PathVariable Long employerId, @RequestParam String mobileNo) throws EmployerNotFoundException {
    	 EmployerDTO updatedEmployer = employerService.updateMobileNo(employerId, mobileNo);
         if(updatedEmployer!=null) {
             return ResponseEntity.ok(updatedEmployer);
          }
          else
          {
     	   throw new EmployerNotFoundException("employer not found ");
          }
        }

      @PutMapping("/{employerId}/updateEmail")
      public ResponseEntity<EmployerDTO> updateEmail(@PathVariable Long employerId, @RequestParam String email) throws EmployerNotFoundException {
    	  EmployerDTO updatedEmployer = employerService.updateEmail(employerId, email);
          if(updatedEmployer!=null) {
              return ResponseEntity.ok(updatedEmployer);
           }
           else
           {
      	   throw new EmployerNotFoundException("employer not found ");
           }
         }
      @PutMapping("/{employerId}/updateCompany")
      public ResponseEntity<EmployerDTO> updateCompany(@PathVariable Long employerId, @RequestParam String company) throws EmployerNotFoundException {
      EmployerDTO updatedEmployer = employerService.updateCompany(employerId, company);
      if(updatedEmployer!=null) {
          return ResponseEntity.ok(updatedEmployer);
       }
       else
       {
  	   throw new EmployerNotFoundException("employer not found ");
       }
     }

      @GetMapping("/findByCompanyName")
       public ResponseEntity<List<EmployerDTO>> findByCompanyName(@RequestParam String name) throws EmployerNotFoundException {
    	  List<EmployerDTO> employers = employerService.findByCompanyName(name);
          if(!employers.isEmpty()) {
              return ResponseEntity.ok(employers);
         }
         else
         {
      	   throw new EmployerNotFoundException("employer not found ");
         }
          }

      @GetMapping("/findByFullName")
      public ResponseEntity<List<EmployerDTO>> findByFullName(@RequestParam String fullName) throws EmployerNotFoundException {
      List<EmployerDTO> employers = employerService.findByFullName(fullName);
      if(!employers.isEmpty()) {
          return ResponseEntity.ok(employers);
     }
     else
     {
  	   throw new EmployerNotFoundException("employer not found ");
     }
      }

      @GetMapping("/findByEmail")
       public ResponseEntity<EmployerDTO> findByEmail(@RequestParam String email) throws EmployerNotFoundException {
       EmployerDTO employer = employerService.findByEmail(email);
       if(employer!=null) {
            return ResponseEntity.ok(employer);
       }
       else
       {
    	   throw new EmployerNotFoundException("employer not found with this email " + email);
       }
      }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<Void> deleteAll() {
            employerService.deleteAll();
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/count")
        public ResponseEntity<Long> count() {
            long employerCount = employerService.count();
            return ResponseEntity.ok(employerCount);
        }

        @DeleteMapping("/deleteAllBatch")
        public ResponseEntity<Void> deleteAllBatch(@RequestBody List<EmployerDTO> employers) {
        	employerService.deleteAll(employers);
        	return ResponseEntity.noContent().build();
        }
        
        @PutMapping ("/addProfile/{id}")
        public ResponseEntity<UserDTO> addEmployerProfile(@PathVariable Long id ,@Valid @RequestBody EmployerDTO employerDTO) throws ResourceNotFoundException {
            UserDTO createdUser = userService.addEmployer(id, employerDTO);
            if(createdUser!=null) {
            	return ResponseEntity.ok(createdUser);
            }
            else
            {
            	throw new ResourceNotFoundException("user is not found");
            }

        }
        @PutMapping("/{employerId}/addJob")
        public ResponseEntity<EmployerDTO> addJob(@PathVariable Long employerId, @RequestBody JobListingDTO jobListingDto) throws EmployerNotFoundException {
      	  EmployerDTO updatedEmployer = employerService.addJobListing(employerId, jobListingDto);
            if(updatedEmployer!=null) {
                return ResponseEntity.ok(updatedEmployer);
             }
             else
             {
        	   throw new EmployerNotFoundException("employer not found ");
             }
           }
}
