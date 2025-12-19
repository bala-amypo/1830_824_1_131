package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

@RestController
@RequestMapping("/zones")
public class ConflictCaseController {

    @Autowired
    private ZoneService zoneService;

    // Create Zone
    @PostMapping
    public Zone createZone(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }

    // Update Zone
    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone);
    }

    // Get Zone by ID
    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable Long id) {
        return zoneService.getZoneById(id);
    }

    // Get All Zones
    @GetMapping
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }

    // Deactivate Zone
    @PutMapping("/{id}/deactivate")
    public Zone deactivateZone(@PathVariable Long id) {
        return zoneService.deactivateZone(id);
    }
}
