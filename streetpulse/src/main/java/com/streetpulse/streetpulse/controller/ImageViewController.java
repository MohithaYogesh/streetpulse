package com.streetpulse.streetpulse.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;

@RestController
@RequestMapping("/images")
public class ImageViewController {

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> viewImage(@PathVariable String filename) {
        try {
            // same uploads folder you used earlier
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            File file = new File(uploadDir + "/" + filename);

            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            byte[] imageBytes = Files.readAllBytes(file.toPath());

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG) // works for most images
                    .body(imageBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
