package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/heatmap")
public class HeatmapController {

    private final ComplaintRepository repo;

    public HeatmapController(ComplaintRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Map<String, Object>> getHeatmapData() {

        List<Complaint> complaints = repo.findAll();
        List<Map<String, Object>> points = new ArrayList<>();

        for (Complaint c : complaints) {
            if (c.getLatitude() != null && c.getLongitude() != null) {

                Map<String, Object> p = new HashMap<>();
                p.put("lat", c.getLatitude());
                p.put("lng", c.getLongitude());

                // simple weight logic
                int weight = 1;
                if ("HIGH".equalsIgnoreCase(String.valueOf(c.getPriority()))) weight = 3;
                if ("CRITICAL".equalsIgnoreCase(String.valueOf(c.getPriority()))) weight = 5;

                p.put("weight", weight);

                points.add(p);
            }
        }
        return points;
    }
}
