package com.streetpulse.streetpulse.repository;

import com.streetpulse.streetpulse.model.ComplaintImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintImageRepository extends JpaRepository<ComplaintImage, Long> {
    List<ComplaintImage> findByComplaintId(Long complaintId);
}
