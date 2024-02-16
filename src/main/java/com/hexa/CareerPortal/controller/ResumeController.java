package com.hexa.CareerPortal.controller;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.Resume;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<ResumeDTO> createResume(@Validated @RequestBody ResumeDTO resumeDTO) {
        ResumeDTO createdResume = resumeService.addResume(resumeDTO);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeDTO> getResumeById(@PathVariable Long resumeId) throws ResourceNotFoundException {
        ResumeDTO resumeDTO = resumeService.findByResumeId(resumeId);
            if (resumeDTO != null) {
                return new ResponseEntity<>(resumeDTO, HttpStatus.OK);
            } else {
                throw new ResourceNotFoundException("User not found with id: " + resumeId);
            }
    }

    @PutMapping("/{resumeId}")
    public ResponseEntity<ResumeDTO> updateResume(@PathVariable Long resumeId, @Validated @RequestBody ResumeDTO resumeDTO) {
        try {
            ResumeDTO updatedResume = resumeService.updateResume(resumeId, resumeDTO);
            return ResponseEntity.ok(updatedResume);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long resumeId) {
        resumeService.deleteById(resumeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResumeDTO>> getAllResumes() {
        List<ResumeDTO> resumes = resumeService.findAll();
        return ResponseEntity.ok(resumes);
    }
}