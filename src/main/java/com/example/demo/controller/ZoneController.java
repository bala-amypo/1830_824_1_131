package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

@RestController
public class AuditTrailRecordController {
    @Autowired
    ZoneService zs;

    @PostMapping("/Zone")
    public Zone addZone(@RequestBody Zone zs){
        return zs.logEvent(zs);
    }

    @GetMapping("/tyu")
    public int first(Long credentialId){
        return zs.getLogs();
    }

    @GetMapping("/Zone")
    second(){
        return zs.getAllLogs();
    }
}