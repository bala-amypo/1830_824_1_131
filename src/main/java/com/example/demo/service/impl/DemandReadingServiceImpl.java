package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repository;

    @Override
    public DemandReading create(DemandReading reading) {
        if (reading.getRecordedAt() == null) {
            reading.setRecordedAt(Instant.now());
        }
        return repository.save(reading);
    }

    @Override
    public List<DemandReading> getByZone(Long zoneId) {
        return repository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {
        return repository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId)
                .orElse(null);
    }

    @Override
    public Page<DemandReading> getPagedByZone(Long zoneId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("recordedAt").descending());
        return repository.findAll(pageable);
    }
}
