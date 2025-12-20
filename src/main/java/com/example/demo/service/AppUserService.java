package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DemandReading;

@Service
public class DemandReadingService {

    public DemandReading createReading(DemandReading reading) {
        
        return reading;
    }

    public List<DemandReading> getReadingsForZone(Long zoneId) {
       
        return List.of();
    }

    public DemandReading getLatestReading(Long zoneId) {
        
        return new DemandReading();
    }

    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        
        return List.of();
    }
}
