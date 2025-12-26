package com.example.demo.service.impl;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRepository zoneRepository;

    public ZoneRestorationServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Zone restoreZone(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        zone.setActive(true);
        zone.setUpdatedAt(Instant.now());

        return zoneRepository.save(zone);
    }

    @Override
    public Zone deactivateZone(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        zone.setActive(false);
        zone.setUpdatedAt(Instant.now());

        return zoneRepository.save(zone);
    }
}
