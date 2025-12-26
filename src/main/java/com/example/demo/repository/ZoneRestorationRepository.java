package com.example.demo.repository;

import com.example.demo.entity.ZoneRestoration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZoneRestorationRepository
        extends JpaRepository<ZoneRestorationRecord, Long> {

    List<ZoneRestorationRecord> findByZoneIdOrderByRestoredAtDesc(Long zoneId);
}
