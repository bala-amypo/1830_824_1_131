package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Zone;

@Service   // 🔥 THIS creates the bean
public class ZoneServiceImpl implements ZoneService {

    @Override
    public Zone createZone(Zone zone) {
        return zone;
    }

    @Override
    public Zone updateZone(Long id, Zone zone) {
        return zone;
    }

    @Override
    public Zone getZoneById(Long id) {
        return null;
    }

    @Override
    public List<Zone> getAllZones() {
        return List.of();
    }

    @Override
    public void deactivateZone(Long id) {
    }
}
