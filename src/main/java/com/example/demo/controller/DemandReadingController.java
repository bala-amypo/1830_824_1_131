package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
public class DemandReadingController {

    private final DemandReadingService demandReadingService;

    @Autowired
    public DemandReadingController(DemandReadingService demandReadingService) {
        this.demandReadingService = demandReadingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DemandReading create(@RequestBody DemandReading demandReading) {
        return demandReadingService.create(demandReading);
    }

    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return demandReadingService.getByZone(zoneId);
    }

    @GetMapping("/zone/{zoneId}/latest")
    public DemandReading getLatest(@PathVariable Long zoneId) {
        return demandReadingService.getLatestByZone(zoneId);
    }

    @GetMapping("/zone/{zoneId}/paged")
    public Page<DemandReading> getPaged(
            @PathVariable Long zoneId,
            @RequestParam int page,
            @RequestParam int size) {

        return demandReadingService.getPagedByZone(zoneId, page, size);
    }
}
