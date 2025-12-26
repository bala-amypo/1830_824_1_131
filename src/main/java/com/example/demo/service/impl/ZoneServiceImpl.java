package com.example.demo.service.impl;

import com.example.demo.entity.Zone;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepo;

    public ZoneServiceImpl(ZoneRepository zoneRepo) {
        this.zoneRepo = zoneRepo;
    }

    // ---------------- CREATE ----------------
    @Override
    public Zone createZone(Zone zone) {

        if (zone.getPriorityLevel() == null || zone.getPriorityLevel() < 1) {
            throw new BadRequestException("Priority must be >= 1");
        }

        zoneRepo.findByZoneName(zone.getZoneName())
                .ifPresent(z -> {
                    throw new BadRequestException("Zone name must be unique");
                });

        if (zone.getActive() == null) {
            zone.setActive(true);
        }

        
        

        return zoneRepo.save(zone);
    }

    // ---------------- UPDATE ----------------
    @Override
    public Zone updateZone(Long id, Zone input) {

        Zone existing = zoneRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );

        if (input.getZoneName() != null) {
            existing.setZoneName(input.getZoneName());
        }

        if (input.getPriorityLevel() != null) {
            if (input.getPriorityLevel() < 1) {
                throw new BadRequestException("Priority must be >= 1");
            }
            existing.setPriorityLevel(input.getPriorityLevel());
        }

        if (input.getActive() != null) {
            existing.setActive(input.getActive());
        }

       

        return zoneRepo.save(existing);
    }

    // ---------------- GET BY ID ----------------
    @Override
    public Zone getZoneById(Long id) {
        return zoneRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<Zone> getAllZones() {
        return zoneRepo.findAll();
    }

    // ---------------- DEACTIVATE ----------------
    @Override
    public void deactivateZone(Long id) {

        Zone zone = zoneRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found")
                );

        zone.setActive(false);
        zone.setUpdatedAt(Instant.now());

        zoneRepo.save(zone);
    }
}
