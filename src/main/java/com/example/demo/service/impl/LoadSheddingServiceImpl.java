package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.SupplyForecast;
import com.example.demo.entity.Zone;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {
    
    private final SupplyForecastRepository forecastRepository;
    private final ZoneRepository zoneRepository;
    private final DemandReadingRepository readingRepository;
    private final LoadSheddingEventRepository eventRepository;
    
    public LoadSheddingServiceImpl(SupplyForecastRepository forecastRepository,
                                   ZoneRepository zoneRepository,
                                   DemandReadingRepository readingRepository,
                                   LoadSheddingEventRepository eventRepository) {
        this.forecastRepository = forecastRepository;
        this.zoneRepository = zoneRepository;
        this.readingRepository = readingRepository;
        this.eventRepository = eventRepository;
    }
    
    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {
        SupplyForecast forecast = forecastRepository.findById(forecastId)
            .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));
        
        List<Zone> activeZones = zoneRepository.findByActiveTrueOrderByPriorityLevelAsc();
        
        if (activeZones.isEmpty()) {
            throw new BadRequestException("No suitable zones available for load shedding");
        }
        
        double totalDemand = 0;
        for (Zone zone : activeZones) {
            Optional<DemandReading> latestReading = readingRepository.findFirstByZoneIdOrderByRecordedAtDesc(zone.getId());
            if (latestReading.isPresent()) {
                totalDemand += latestReading.get().getDemandMW();
            }
        }
        
        if (totalDemand <= forecast.getAvailableSupplyMW()) {
            throw new BadRequestException("No overload detected");
        }
        
        double deficit = totalDemand - forecast.getAvailableSupplyMW();
        
        // Select lowest priority zone (highest priority number) with sufficient demand
        Zone selectedZone = null;
        double selectedDemand = 0;
        
        for (int i = activeZones.size() - 1; i >= 0; i--) {
            Zone zone = activeZones.get(i);
            Optional<DemandReading> reading = readingRepository.findFirstByZoneIdOrderByRecordedAtDesc(zone.getId());
            if (reading.isPresent() && reading.get().getDemandMW() > 0) {
                selectedZone = zone;
                selectedDemand = reading.get().getDemandMW();
                break;
            }
        }
        
        if (selectedZone == null) {
            throw new BadRequestException("No suitable zones with demand");
        }
        LoadSheddingEvent event = LoadSheddingEvent.builder()
        .zoneId(zone.getId())
        .eventStart(Instant.now())
        .reason("Load shedding triggered due to supply deficit")
        .triggeredByForecastId(forecastId)
        .expectedDemandReductionMW(Math.max(deficit, selectedDemand))
        .build();


         return eventRepository.save(event);

    }
    
    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }
    
    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepository.findByZoneIdOrderByEventStartDesc(zoneId);
    }
    
    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}