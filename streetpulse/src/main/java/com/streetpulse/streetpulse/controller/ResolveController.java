package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.Complaint;
import com.streetpulse.streetpulse.repository.ComplaintRepository;
import com.streetpulse.streetpulse.repository.UserRepository;
import com.streetpulse.streetpulse.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resolve")
@CrossOrigin
public class ResolveController {

    private final ComplaintRepository complaintRepo;
    private final UserRepository userRepo;

    public ResolveController(ComplaintRepository complaintRepo,
                             UserRepository userRepo) {
        this.complaintRepo = complaintRepo;
        this.userRepo = userRepo;
    }

    // BOTH admin & volunteer can use this
    @PutMapping("/{complaintId}/by/{userId}")
    public String resolveComplaint(@PathVariable Long complaintId,
                                   @PathVariable Long userId) {

        User user = userRepo.findById(userId).orElseThrow();

        // Allow only ADMIN or VOLUNTEER
        if (!(user.getRole().name().equals("ADMIN") ||
                user.getRole().name().equals("VOLUNTEER"))) {

            return "You are not allowed to resolve complaints";
        }

        Complaint c = complaintRepo.findById(complaintId).orElseThrow();
        c.setStatus("Resolved");
        complaintRepo.save(c);

        return "Complaint resolved by " + user.getRole();
    }
}
