package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository demandReadingRepository;
    private final ZoneRepository zoneRepository;

    public DemandReadingServiceImpl(DemandReadingRepository demandReadingRepository,
                                    ZoneRepository zoneRepository) {
        this.demandReadingRepository = demandReadingRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {

        // Ensure zone exists
        Long zoneId = reading.getZone().getId();
        zoneRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        return demandReadingRepository.save(reading);
    }

    @Override
    public List<DemandReading> getReadingsForZone(Long zoneId) {
        return demandReadingRepository.findByZoneId(zoneId);
    }

    @Override
    public DemandReading getLatestReading(Long zoneId) {
        return demandReadingRepository
                .findFirstByZoneIdOrderByRecordedAtDesc(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("No readings found"));
    }

    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        return demandReadingRepository
                .findByZoneIdOrderByRecordedAtDesc(zoneId, PageRequest.of(0, limit));
    }
}
