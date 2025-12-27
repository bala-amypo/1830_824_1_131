package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final List<ZoneRestorationRecord> records = new ArrayList<>();

    @Override
    public ZoneRestorationRecord saveRestoration(ZoneRestorationRecord record) {
        records.add(record);
        return record;
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return records.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return records;
    }

    @Override
    public List<ZoneRestorationRecord> getAllRestorations() {
        return records;
    }
}
