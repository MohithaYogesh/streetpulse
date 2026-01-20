package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heatmap")
public class HeatmapController {

    private final ComplaintRepository repo;

    public HeatmapController(ComplaintRepository repo) {
        this.repo = repo;
    }

    // Used by citizen, admin, volunteer
    @GetMapping("/data")
    public List<Complaint> getHeatmapData() {
        return repo.findAll();
    }
}
