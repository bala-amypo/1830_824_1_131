package com.example.demo.service.impl;

import com.example.demo.model.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingEventRepository eventRepository;

    public LoadSheddingServiceImpl(LoadSheddingEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

        // Create a new event with only forecastId
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setForecastId(forecastId);
        event.setCreatedAt(java.time.LocalDateTime.now());

        return eventRepository.save(event);
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return eventRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepository.findByZoneId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}
