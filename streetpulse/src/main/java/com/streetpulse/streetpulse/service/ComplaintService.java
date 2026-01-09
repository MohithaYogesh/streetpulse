package com.streetpulse.streetpulse.service;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public Complaint save(Complaint c) {
        c.setStatus("Pending");
        c.setCreatedAt(LocalDateTime.now());
        return repo.save(c);
    }

    public List<Complaint> getAll() {
        return repo.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found with id " + id));
        c.setStatus(status);
        return repo.save(c);
    }
}
