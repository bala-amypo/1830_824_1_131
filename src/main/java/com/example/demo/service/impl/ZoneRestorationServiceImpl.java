package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Override
public ZoneRestorationRecord saveRestoration(Long zoneId) {
    return new ZoneRestorationRecord();
}

@Override
public ZoneRestorationRecord getRecordById(Long id) {
    return new ZoneRestorationRecord();
}

@Override
public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
    return List.of();
}
