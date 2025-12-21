package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRepository zoneRestorationRepository;

    public ZoneRestorationServiceImpl(ZoneRestorationRepository zoneRestorationRepository) {
        this.zoneRestorationRepository = zoneRestorationRepository;
    }

    @Override
    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord record) {
        return zoneRestorationRepository.save(record);
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return zoneRestorationRepository.findById(id)
                .orElse(null);
    }

    @Override
    public ZoneRestorationRecord getRecordsForZone(Long zoneId) {
        return zoneRestorationRepository.findByZoneId(zoneId);
    }
}
