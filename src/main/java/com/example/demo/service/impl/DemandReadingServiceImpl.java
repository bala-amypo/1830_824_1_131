package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.entity.Zone;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository readingRepo;
    private final ZoneRepository zoneRepo;

    public DemandReadingServiceImpl(
            DemandReadingRepository readingRepo,
            ZoneRepository zoneRepo
    ) {
        this.readingRepo = readingRepo;
        this.zoneRepo = zoneRepo;
    }

    // ---------------- CREATE ----------------
    @Override
    public DemandReading createReading(DemandReading reading) {

        if (reading.getDemandMW() < 0) {
            throw new BadRequestException("Demand must be >= 0");
        }

        if (reading.getRecordedAt().isAfter(Instant.now())) {
            throw new BadRequestException("Recorded time cannot be in future");
        }

        Long zoneId = reading.getZone().getId();

        Zone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );

        reading.setZone(zone);

        return readingRepo.save(reading);
    }

    // ---------------- GET LATEST ----------------
    @Override
    public DemandReading getLatestReading(Long zoneId) {

        return readingRepo
                .findFirstByZoneIdOrderByRecordedAtDesc(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No readings found")
                );
    }

    // ---------------- GET ALL FOR ZONE ----------------
    @Override
    public List<DemandReading> getReadingsForZone(Long zoneId) {

        zoneRepo.findById(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );

        return readingRepo.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    // ---------------- GET RECENT WITH LIMIT ----------------
    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {

        zoneRepo.findById(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );

        List<DemandReading> all =
                readingRepo.findByZoneIdOrderByRecordedAtDesc(zoneId);

        if (all.size() <= limit) {
            return all;
        }

        return all.subList(0, limit);
    }
}
