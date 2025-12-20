package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoadSheddingEvent;

@Service
public class LoadSheddingService {

    public demandReading createReading(DemandReading reading) {
        
        return new DemandReading();
    }

    public LoadSheddingEvent getEventById(Long id) {
        
        return new LoadSheddingEvent();
    }

    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
      
        return List.of();
    }

    public List<LoadSheddingEvent> getAllEvents() {
        return List.of();
    }
}
