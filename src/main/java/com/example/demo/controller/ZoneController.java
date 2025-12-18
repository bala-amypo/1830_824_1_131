package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

public class LocationController {

    @Autowired
    ZoneService zs;

    // for post the data
    @PostMapping("/api/zones")
    public Zone addZone(@Valid @RequestBody Zone zsc) {
        return zs.createZone(Zone zone);
    }

    // for get all the data in list view
    @GetMapping
    public List<Zone> getAll() {
        return zs.getAllZones();
    }

    @GetMapping("/{id}")
    public Zone getZone(@PathVariable Long id) {
        return zs.getZoneById(Long id);
    }

    @PutMapping("/{id}")
    public Zone update(
            @PathVariable Long id,
            @Valid @RequestBody Zone update) {
        return lcs.updateZone(Long id,Zone zone);
    }

     @PutMapping("/{id}/deactivate")
    public Zone update(
            @PathVariable Long id,
            @Valid @RequestBody Zone update) {
        return lcs.deactivateZone(Long id);
    }


}
