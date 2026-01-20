package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.service.AdminComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/complaints")
public class AdminComplaintController {

    private final AdminComplaintService service;

    public AdminComplaintController(AdminComplaintService service) {
        this.service = service;
    }

    @GetMapping
    public List<Complaint> getAll() {
        return service.getAllComplaints();
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id,
                                  @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteComplaint(id);
    }
}
