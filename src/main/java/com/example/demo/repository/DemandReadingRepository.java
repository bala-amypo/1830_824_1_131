package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DemandReadingRepository
        extends JpaRepository<DemandReading, Long> {

    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId);

    Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);
}

