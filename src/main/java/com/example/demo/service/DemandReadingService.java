package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoadSheddingEvent;

@Service
public class LoadSheddingService {

    public DemandReading createReading(DemandReading reading) {
        
        return new DemandReading();
    }

    public DemandReading getReadingsForZone(Long zoneId) {
        
        return new DemandReading();
    }

    public DemandReading getLatestReading(Long zoneId) {
      
        return new DemandReading();
    }

    public  getAllEvents() {
        return List.of();
    }
}
