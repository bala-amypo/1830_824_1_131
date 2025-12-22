package com.example.demo.service.impl;

import com.example.demo.model.Forecast;
import com.example.demo.model.LoadSheddingEvent;
import com.example.demo.model.Zone;
import com.example.demo.repository.ForecastRepository;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final ForecastRepository forecastRepository;
    private final LoadSheddingEventRepository loadSheddingEventRepository;
    private final ZoneRepository zoneRepository;

    public LoadSheddingServiceImpl(ForecastRepository forecastRepository,
                                   LoadSheddingEventRepository loadSheddingEventRepository,
                                   ZoneRepository zoneRepository) {

        this.forecastRepository = forecastRepository;
        this.loadSheddingEventRepository = loadSheddingEventRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

        Forecast forecast = forecastRepository.findById(forecastId)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));

        // If Demand <= Supply → No shedding needed
        if (forecast.getDemand() <= forecast.getSupply()) {
            throw new RuntimeException("No overload detected.");
        }

        double currentDemand = forecast.getDemand();
        double supply = forecast.getSupply();

        List<Zone> zonesToShed = new ArrayList<>();

        // Step 1 → find lowest priority active zones
        List<Zone> zones =
                zoneRepository.findByActiveTrueOrderByPriorityLevelAsc();

        for (Zone z : zones) {

            if (currentDemand <= supply)
                break;

            zonesToShed.add(z);

            // reduce demand after disabling zone
            currentDemand -= z.getPowerConsumption();

            // deactivate OR mark shed
            z.setActive(false);
            zoneRepository.save(z);
        }

        if (currentDemand > supply) {
            throw new RuntimeException("Load shedding insufficient to resolve overload!");
        }

        // Step 2: create event record
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setForecastId(forecastId);
        event.setCreatedAt(LocalDateTime.now());
        event.setZones(zonesToShed);

        return loadSheddingEventRepository.save(event);
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return loadSheddingEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return loadSheddingEventRepository.findByZonesId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return loadSheddingEventRepository.findAll();
    }
}
