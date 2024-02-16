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
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.EmployerDTO;
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
    public ResponseEntity<EmployerDTO> getEmployerById(@PathVariable Long employerId) throws ResourceNotFoundException {
        EmployerDTO employerDTO = employerService.findById(employerId);
        if (employerDTO != null) {
            return ResponseEntity.ok(employerDTO);
        } else {
            throw new ResourceNotFoundException("Employer not found with id: " + employerId);
        }
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable Long employerId, @Validated @RequestBody EmployerDTO employerDTO) throws ResourceNotFoundException {
        EmployerDTO updatedEmployer = employerService.updateEmployer(employerId, employerDTO);
        if (updatedEmployer != null) {
            return ResponseEntity.ok(updatedEmployer);
        } else {
            throw new ResourceNotFoundException("Employer not found with id: " + employerId);
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
}
