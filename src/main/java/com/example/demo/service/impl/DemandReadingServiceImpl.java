package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository demandReadingRepository;

    public DemandReadingServiceImpl(DemandReadingRepository demandReadingRepository) {
        this.DemandReadingRepository = demandReadingRepository;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return DemandReadingRepository.save(reading);
    }

    @Override
    public List<DemandReading> getReadingsByZone(Long zoneId) {
        return DemandReadingRepository.findByZoneId(zoneId);
    }

    @Override
    public DemandReading getLatestReading(Long zoneId) {
        DemandReading reading =
                DemandReadingRepository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId);

        if (reading == null) {
            throw new ResourceNotFoundException(
                    "No demand reading found for zone id: " + zoneId);
        }

        return reading;
    }

    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        return DemandReadingRepository
                .findByZoneId(
                        zoneId,
                        PageRequest.of(
                                0,
                                limit,
                                Sort.by(Sort.Direction.DESC, "recordedAt")
                        )
                )
                .getContent();
    }
}
