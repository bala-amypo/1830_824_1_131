package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    @Override
    public ZoneRestorationRecord createRestoration(ZoneRestorationRecord record) {
        return record;
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return null;
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return new ArrayList<>();
    }

    @Override
    public List<ZoneRestorationRecord> getAllRestorations() {
        return new ArrayList<>();
    }
}
