package com.streetpulse.streetpulse.service;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final ComplaintRepository repo;

    public VolunteerService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public List<Complaint> getOpenComplaints() {
        return repo.findAll()
                .stream()
                .filter(c -> !"Resolved".equalsIgnoreCase(c.getStatus()))
                .toList();
    }

    public Complaint markInProgress(Long id) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setStatus("In Progress");
        return repo.save(c);
    }
}
