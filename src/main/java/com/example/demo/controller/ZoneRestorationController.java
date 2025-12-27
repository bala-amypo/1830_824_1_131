package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restorations")
@Tag(name = "Zone Restoration Management", description = "APIs for managing zone restoration records")
public class ZoneRestorationController {
    
    private final ZoneRestorationService restorationService;
    
    public ZoneRestorationController(ZoneRestorationService restorationService) {
        this.restorationService = restorationService;
    }
    
    @PostMapping
     public ResponseEntity<ZoneRestorationRecord> restoreZone(@RequestBody ZoneRestorationRecord record) {
    return ResponseEntity.ok(restorationService.saveRestoration(record));
}

    
    @GetMapping("/{id}")
    public ResponseEntity<ZoneRestorationRecord> getRecord(@PathVariable Long id) {
        return ResponseEntity.ok(restorationService.getRecordById(id));
    }
    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<ZoneRestorationRecord>> getRecordsForZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(restorationService.getRecordsForZone(zoneId));
    }
}