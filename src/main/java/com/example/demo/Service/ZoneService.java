package com.example.demo.service;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    // CREATE
    public Zone createZone(Zone zone) {
        zoneRepository.findByZoneName(zone.getZoneName())
                .ifPresent(z -> {
                    throw new IllegalArgumentException("Zone name must be unique");
                });

        return zoneRepository.save(zone);
    }

    // UPDATE
    public Zone updateZone(Long id, Zone zone) {
        Zone existing = zoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Zone not found"));

        existing.setZoneName(zone.getZoneName());
        existing.setPriorityLevel(zone.getPriorityLevel());
        existing.setPopulation(zone.getPopulation());

        return zoneRepository.save(existing);
    }

    // GET BY ID
    public Zone getZoneById(Long id) {
        return zoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Zone not found"));
    }

    // GET ALL
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    // DEACTIVATE
    public void deactivateZone(Long id) {
        Zone zone = getZoneById(id);
        zone.setActive(false);
        zoneRepository.save(zone);
    }
}
