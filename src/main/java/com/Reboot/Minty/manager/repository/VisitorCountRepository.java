package com.Reboot.Minty.manager.repository;

import com.Reboot.Minty.manager.entity.VisitorCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VisitorCountRepository extends JpaRepository<VisitorCount, LocalDate> {
    VisitorCount findByVisitDate(LocalDate date);
    // Add other methods as needed
}
