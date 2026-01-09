package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.ComplaintImage;
import com.streetpulse.streetpulse.repository.ComplaintImageRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ImageController {

    private final ComplaintImageRepository repo;

    public ImageController(ComplaintImageRepository repo) {
        this.repo = repo;
    }

    // -----------------------------
    // 1. UPLOAD IMAGE
    // -----------------------------
    @PostMapping("/{id}/image")
    public String uploadImage(@PathVariable Long id,
                              @RequestParam("file") MultipartFile file) {

        try {
            if (file == null || file.isEmpty()) {
                return "No file received";
            }

            // Create uploads folder if not exists
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Make filename safe
            String safeName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File dest = new File(dir, safeName);

            // Save file to disk
            file.transferTo(dest);

            // Save file info in DB
            ComplaintImage img = new ComplaintImage();
            img.setComplaintId(id);
            img.setImagePath(dest.getAbsolutePath());
            repo.save(img);

            return "Image uploaded successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Upload failed: " + e.getMessage();
        }
    }

    // -----------------------------
    // 2. VIEW IMAGES OF A COMPLAINT
    // -----------------------------
    @GetMapping("/{id}/images")
    public List<ComplaintImage> getImages(@PathVariable Long id) {
        return repo.findByComplaintId(id);
    }
}
