package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
public class DemandReadingController {

    private final DemandReadingService demandReadingService;
    private final DemandReadingRepository demandReadingRepository;

    public DemandReadingController(
            DemandReadingService demandReadingService,
            DemandReadingRepository demandReadingRepository) {
        this.demandReadingService = demandReadingService;
        this.demandReadingRepository = demandReadingRepository;
    }

    // POST /api/demand-readings
    @PostMapping
    public ResponseEntity<DemandReading> createReading(
            @RequestBody DemandReading reading) {
        return ResponseEntity.ok(demandReadingService.createReading(reading));
    }

    // GET /api/demand-readings/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DemandReading> getReadingById(@PathVariable Long id) {
        DemandReading reading = demandReadingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Demand reading not found with id: " + id));
        return ResponseEntity.ok(reading);
    }

    // GET /api/demand-readings/zone/{zoneId}
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<DemandReading>> getReadingsForZone(
            @PathVariable Long zoneId) {
        return ResponseEntity.ok(
                demandReadingService.getReadingsByZone(zoneId));
    }

    // GET /api/demand-readings/zone/{zoneId}/latest
    @GetMapping("/zone/{zoneId}/latest")
    public ResponseEntity<DemandReading> getLatestReading(
            @PathVariable Long zoneId) {
        return ResponseEntity.ok(
                demandReadingService.getLatestReading(zoneId));
    }

    // GET /api/demand-readings/zone/{zoneId}/recent?limit=5
    @GetMapping("/zone/{zoneId}/recent")
    public ResponseEntity<List<DemandReading>> getRecentReadings(
            @PathVariable Long zoneId,
            @RequestParam(defaultValue = "5") int limit) {

        List<DemandReading> readings =
                demandReadingRepository.findByZoneId(
                        zoneId,
                        PageRequest.of(
                                0,
                                limit,
                                Sort.by(Sort.Direction.DESC, "recordedAt")
                        )
                ).getContent();

        return ResponseEntity.ok(readings);
    }
}
