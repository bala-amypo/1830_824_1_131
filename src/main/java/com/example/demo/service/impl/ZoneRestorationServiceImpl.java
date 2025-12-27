package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    @Override
    public ZoneRestorationRecord createRecord(ZoneRestorationRecord record) {
        return record;
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return null;
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return List.of();
    }
}
