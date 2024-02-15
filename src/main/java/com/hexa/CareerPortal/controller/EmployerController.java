package com.hexa.CareerPortal.controller;

import com.hexa.CareerPortal.dto.EmployerDTO;
import com.hexa.CareerPortal.entity.Employer;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.EmployerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<EmployerDTO> createEmployer(@Valid @RequestBody EmployerDTO employerDTO) {
        EmployerDTO createdEmployer = employerService.createEmployer(employerDTO);
        return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<EmployerDTO> getEmployerById(@PathVariable Long employerId) {
        EmployerDTO employerDTO = employerService.findById(employerId);
        if (employerDTO != null) {
            return ResponseEntity.ok(employerDTO);
        } else {
            throw new ResourceNotFoundException("Employer not found with id: " + employerId);
        }
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable Long employerId, @Validated @RequestBody EmployerDTO employerDTO) {
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
