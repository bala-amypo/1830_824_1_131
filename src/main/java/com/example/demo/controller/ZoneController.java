//ConflictCaseController.java                                                                                                                                                                                      package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

    
    @PostMapping
     public Zone createCase(@RequestBody ZoneService ZoneService){
        return ZoneService.createZone(Zone zone);
     }
    @PutMapping("/{id}")
    public Zone updateZone(@PathVariabl Long id,@RequestParam String ,Zone zone){
        return ZoneService.updateZone(Long id,Zone zone);

    }
    

    @GetMapping
    public List<Zone>getZoneById(@PathVariable Long Id) {
        return ZoneService.getZoneById(Long id);
    }

    @GetMapping("/{id}")
    public Zone getAllZones() {
        return lcs.getViewByID(id);
    }
    
}