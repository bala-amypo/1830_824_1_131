package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final SupplyForecastRepository supplyForecastRepository;
    private final ZoneRepository zoneRepository;
    private final LoadSheddingEventRepository loadSheddingEventRepository;

    public LoadSheddingServiceImpl(
            SupplyForecastRepository supplyForecastRepository,
            ZoneRepository zoneRepository,
            LoadSheddingEventRepository loadSheddingEventRepository) {
        this.supplyForecastRepository = supplyForecastRepository;
        this.zoneRepository = zoneRepository;
        this.loadSheddingEventRepository = loadSheddingEventRepository;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

        // 1. Fetch forecast
        SupplyForecast forecast = supplyForecastRepository.findById(forecastId)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

        double demand = forecast.getDemandMW();
        double supply = forecast.getSupplyMW();

        // 2. Check overload
        if (demand <= supply) {
            return null; // No load shedding required
        }

        // 3. Find lowest priority active zones
        List<Zone> zones =
                zoneRepository.findByActiveTrueOrderByPriorityLevelAsc();

        // 4. Shed load until demand <= supply
        for (Zone zone : zones) {
            if (demand <= supply) {
                break;
            }
            demand -= zone.getLoadMW();
            zone.setActive(false);
            zoneRepository.save(zone);
        }

        // 5. Create LoadSheddingEvent
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setForecast(forecast);
        event.setEventStart(LocalDateTime.now());

        return loadSheddingEventRepository.save(event);
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return loadSheddingEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return loadSheddingEventRepository.findByZoneId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return loadSheddingEventRepository.findAll();
    }
}
