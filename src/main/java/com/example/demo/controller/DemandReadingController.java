package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
@Tag(name = "Demand Reading Management", description = "APIs for managing power demand readings")
public class DemandReadingController {
    
    private final DemandReadingService readingService;
    
    public DemandReadingController(DemandReadingService readingService) {
        this.readingService = readingService;
    }
    
    @PostMapping
    public ResponseEntity<DemandReading> createReading(@RequestBody DemandReading reading) {
        return ResponseEntity.ok(readingService.createReading(reading));
    }
    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<DemandReading>> getReadingsForZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(readingService.getReadingsForZone(zoneId));
    }
    
    @GetMapping("/zone/{zoneId}/latest")
    public ResponseEntity<DemandReading> getLatestReading(@PathVariable Long zoneId) {
        return ResponseEntity.ok(readingService.getLatestReading(zoneId));
    }
    
    @GetMapping("/zone/{zoneId}/recent")
    public ResponseEntity<List<DemandReading>> getRecentReadings(
            @PathVariable Long zoneId, 
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(readingService.getRecentReadings(zoneId, limit));
    }
}