// package com.example.demo.controller;

// import com.example.demo.entity.ZoneRestorationRecord;
// import com.example.demo.service.ZoneRestorationService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/zone-restoration")
// public class ZoneRestorationController {

//     private final ZoneRestorationService restorationService;

//     public ZoneRestorationController(ZoneRestorationService restorationService) {
//         this.restorationService = restorationService;
//     }

//     @PostMapping
//     public ZoneRestorationRecord restoreZone(
//             @RequestBody ZoneRestorationRecord record) {
//         return restorationService.restoreZone(record);
//     }

//     @GetMapping("/{id}")
//     public ZoneRestorationRecord getById(@PathVariable Long id) {
//         return restorationService.getRecordById(id);
//     }

//     @GetMapping("/zone/{zoneId}")
//     public ZoneRestorationRecord getByZoneId(@PathVariable Long zoneId) {
//         return restorationService.getRecordsForZone(zoneId);
//     }
// }
