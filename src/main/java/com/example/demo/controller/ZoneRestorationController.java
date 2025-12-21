package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restorations")
public class ZoneRestorationController {

    private final ZoneRestorationService restorationService;

    public ZoneRestorationController(ZoneRestorationService restorationService) {
        this.restorationService = restorationService;
    }

    // -------------------------------
    // POST: Create restoration record
    // -------------------------------
    @PostMapping("/")
    public ZoneRestorationRecord restoreZone(@RequestBody ZoneRestorationRecord record) {
        return restorationService.restoreZone(record);
    }

    // -----------------------------------
    // GET: Get restoration record by ID
    // -----------------------------------
    @GetMapping("/{id}")
    public ZoneRestorationRecord getRestorationById(@PathVariable Long id) {
        return restorationService.getRestorationById(id);
    }

    // --------------------------------------------------------
    // GET: List restoration records for specific zone
    // --------------------------------------------------------
    @GetMapping("/zone/{zoneId}")
    public List<ZoneRestorationRecord> getZoneRestorations(@PathVariable Long zoneId) {
        return restorationService.getRestorationsByZoneId(zoneId);
    }

}
