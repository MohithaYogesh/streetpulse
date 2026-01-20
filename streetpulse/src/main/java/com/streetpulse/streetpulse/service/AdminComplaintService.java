package com.streetpulse.streetpulse.service;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminComplaintService {

    private final ComplaintRepository repo;

    public AdminComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public List<Complaint> getAllComplaints() {
        return repo.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setStatus(status);
        return repo.save(c);
    }

    public void deleteComplaint(Long id) {
        repo.deleteById(id);
    }
}
