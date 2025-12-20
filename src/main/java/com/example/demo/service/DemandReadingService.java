package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DemandReading;

@Service
public class DemandReadingService {

    public DemandReading createReading(DemandReading reading) {
        // TODO: save reading to DB
        return reading;
    }

    public List<DemandReading> getReadingsForZone(Long zoneId) {
        // TODO: fetch readings for zone
        return List.of();
    }

    public DemandReading getLatestReading(Long zoneId) {
        // TODO: fetch latest reading
        return new DemandReading();
    }

    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        // TODO: fetch recent readings with limit
        return List.of();
    }
}
