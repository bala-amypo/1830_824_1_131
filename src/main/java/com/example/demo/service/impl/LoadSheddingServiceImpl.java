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

import java.util.List;
import java.util.Optional;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final SupplyForecastRepository forecastRepository;
    private final ZoneRepository zoneRepository;
    private final DemandReadingRepository readingRepository;
    private final LoadSheddingEventRepository eventRepository;

    public LoadSheddingServiceImpl(
            SupplyForecastRepository forecastRepository,
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

        List<Zone> activeZones =
                zoneRepository.findByActiveTrueOrderByPriorityLevelAsc();

        if (activeZones.isEmpty()) {
            throw new BadRequestException("No active zones available");
        }

        double totalDemand = 0;

        for (Zone z : activeZones) {
            Optional<DemandReading> reading =
                    readingRepository.findFirstByZoneIdOrderByRecordedAtDesc(z.getId());

            if (reading.isPresent()) {
                totalDemand += reading.get().getDemandMW();
            }
        }

        if (totalDemand <= forecast.getAvailableSupplyMW()) {
            throw new BadRequestException("No overload detected");
        }

        double deficit = totalDemand - forecast.getAvailableSupplyMW();

        Zone selectedZone = null;
        double selectedDemand = 0;

        for (int i = activeZones.size() - 1; i >= 0; i--) {
            Zone z = activeZones.get(i);

            Optional<DemandReading> reading =
                    readingRepository.findFirstByZoneIdOrderByRecordedAtDesc(z.getId());

            if (reading.isPresent() && reading.get().getDemandMW() > 0) {
                selectedZone = z;
                selectedDemand = reading.get().getDemandMW();
                break;
            }
        }

        if (selectedZone == null) {
            throw new BadRequestException("No suitable zone found");
        }

        // ✅ FIXED builder (only valid fields)
        LoadSheddingEvent event = LoadSheddingEvent.builder()
                .zoneId(selectedZone.getId())
                .triggeredByForecastId(forecastId)
                .expectedDemandReductionMW(Math.min(deficit, selectedDemand))
                .reason("Load shedding due to supply deficit")
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
