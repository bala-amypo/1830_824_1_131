package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository demandReadingRepository;

    @Autowired
    public DemandReadingServiceImpl(DemandReadingRepository demandReadingRepository) {
        this.demandReadingRepository = demandReadingRepository;
    }

    @Override
    public DemandReading create(DemandReading demandReading) {
        demandReading.setRecordedAt(LocalDateTime.now());
        return demandReadingRepository.save(demandReading);
    }

    @Override
    public List<DemandReading> getByZone(Long zoneId) {
        return demandReadingRepository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {
        return demandReadingRepository
                .findFirstByZoneIdOrderByRecordedAtDesc(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No demand reading found for zone " + zoneId));
    }

    @Override
    public Page<DemandReading> getPagedByZone(Long zoneId, int page, int size) {
        return demandReadingRepository.findByZoneId(
                zoneId,
                PageRequest.of(page, size)
        );
    }
}
