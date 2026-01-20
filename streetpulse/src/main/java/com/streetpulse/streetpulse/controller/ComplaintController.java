package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    // ---------- SAVE COMPLAINT (JSON) ----------
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Complaint c) {

        if (c.getTitle() == null || c.getTitle().isBlank()) {
            return ResponseEntity.badRequest().body("Title is required");
        }

        Complaint saved = service.save(c);
        return ResponseEntity.ok(saved);
    }

    // ---------- UPLOAD IMAGE ----------
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {

        String uploadDir = "uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);

        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }
}
