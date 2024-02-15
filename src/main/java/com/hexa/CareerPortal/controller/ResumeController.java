package com.hexa.CareerPortal.controller;

import com.hexa.CareerPortal.dto.ResumeDTO;
import com.hexa.CareerPortal.entity.Resume;
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
        ResumeDTO createdResume = resumeService.createResume(resumeDTO);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeDTO> getResumeById(@PathVariable Long resumeId) {
        try {
            ResumeDTO resumeDTO = resumeService.findByResumeId(resumeId);
            return ResponseEntity.ok(resumeDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
        resumeService.deleteResume(resumeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResumeDTO>> getAllResumes() {
        List<ResumeDTO> resumes = resumeService.findAll();
        return ResponseEntity.ok(resumes);
    }
}