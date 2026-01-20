package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.service.VolunteerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    // View all open issues
    @GetMapping("/issues")
    public List<Complaint> getIssues() {
        return service.getOpenComplaints();
    }

    // Mark issue as "In Progress"
    @PutMapping("/issues/{id}/start")
    public Complaint startResolving(@PathVariable Long id) {
        return service.markInProgress(id);
    }
}
