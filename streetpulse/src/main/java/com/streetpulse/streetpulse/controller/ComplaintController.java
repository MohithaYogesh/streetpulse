package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @GetMapping
    public List<Complaint> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint c) {
        return service.save(c);
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id,
                                  @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
