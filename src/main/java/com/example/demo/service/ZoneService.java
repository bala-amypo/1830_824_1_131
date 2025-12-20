package com.example.demo.service;

import com.example.demo.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneService {

    private final List<Zone> zones = new ArrayList<>();

    // CREATE
    public Zone createZone(Zone zone) {
        zones.add(zone);
        return zone;
    }

    // UPDATE
    public Zone updateZone(Long id, Zone updatedZone) {
        for (Zone zone : zones) {
            if (zone.getId().equals(id)) {
                zone.setName(updatedZone.getName());
                return zone;
            }
        }
        return null;
    }

    // GET BY ID
    public Zone getZoneById(Long id) {
        return zones.stream()
                .filter(z -> z.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // GET ALL
    public List<Zone> getAllZones() {
        return zones;
    }

    // DEACTIVATE
    public Zone deactivateZone(Long id) {
        Zone zone = getZoneById(id);
        if (zone != null) {
            zone.setActive(false);
        }
        return zone;
    }
}
