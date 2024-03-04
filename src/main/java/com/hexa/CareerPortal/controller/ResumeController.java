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
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.exception.ResumeNotFoundException;
import com.hexa.CareerPortal.service.ResumeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping //checked
    public ResponseEntity<ResumeDTO> createResume(@Validated @RequestBody ResumeDTO resumeDTO) {
        ResumeDTO createdResume = resumeService.addResume(resumeDTO);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @GetMapping("/{resumeId}")  //checked
    public ResponseEntity<ResumeDTO> getResumeById(@PathVariable Long resumeId) throws ResumeNotFoundException {
        ResumeDTO resumeDTO = resumeService.findByResumeId(resumeId);
            if (resumeDTO != null) 
            {
                return new ResponseEntity<>(resumeDTO, HttpStatus.OK);
            }
            else 
            {
                throw new ResumeNotFoundException("Resume not found with id: " + resumeId);
            }
    }

    @PutMapping("/{resumeId}")  //checked
    public ResponseEntity<ResumeDTO> updateResume(@PathVariable Long resumeId, @Validated @RequestBody ResumeDTO resumeDTO) throws ResumeNotFoundException {
            ResumeDTO updatedResume = resumeService.updateResume(resumeId, resumeDTO);
            if (resumeDTO != null) 
            {    
            return new ResponseEntity<>(updatedResume,HttpStatus.OK);
        } 
            else
        {
            	 throw new ResumeNotFoundException("Resume not found with id: " + resumeId);
        }
    }

    @DeleteMapping("/{resumeId}")  //checked
    public ResponseEntity<Void> deleteResume(@PathVariable Long resumeId) {
        resumeService.deleteById(resumeId);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllResumes() {
    	resumeService.deleteAll();
    	return ResponseEntity.noContent().build();
        
    }

    @GetMapping  //checked
    public ResponseEntity<List<ResumeDTO>> getAllResumes() throws ResumeNotFoundException {
        List<ResumeDTO> resumes = resumeService.findAll();
        if(!resumes.isEmpty())
        {
        	return ResponseEntity.ok(resumes);
        }
         else
        {
        	 throw new ResumeNotFoundException("Resumes not found ");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        long count= resumeService.count();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<ResumeDTO>> createResumes(@RequestBody List<ResumeDTO>resumes) {
        List<ResumeDTO> createdResumes = resumeService.addResumes(resumes);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResumes);
    }
}