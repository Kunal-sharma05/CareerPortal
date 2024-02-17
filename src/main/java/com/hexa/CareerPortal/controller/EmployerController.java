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

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.exception.EmployerNotFoundException;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.EmployerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<EmployerDTO> createEmployer(@Valid @RequestBody EmployerDTO employerDTO) {
        EmployerDTO createdEmployer = employerService.createEmployer(employerDTO);
        return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<EmployerDTO> getEmployerById(@PathVariable Long employerId) throws EmployerNotFoundException {
        EmployerDTO employerDTO = employerService.findById(employerId);
        if (employerDTO != null) {
            return ResponseEntity.ok(employerDTO);
        } else {
        	throw new EmployerNotFoundException("Employer not found with id: " + employerId);
        }
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable Long employerId, @Validated @RequestBody EmployerDTO employerDTO) throws EmployerNotFoundException {
        EmployerDTO updatedEmployer = employerService.updateEmployer(employerId, employerDTO);
        if (updatedEmployer != null) {
            return ResponseEntity.ok(updatedEmployer);
        } else {
        	throw new EmployerNotFoundException("employer not found ");
        }
    }

    @DeleteMapping("/{employerId}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long employerId) {
        employerService.deleteById(employerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
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
          if(employers!=null) {
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
      if(employers!=null) {
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
}
