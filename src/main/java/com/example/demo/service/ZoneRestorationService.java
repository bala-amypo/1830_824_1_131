package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationService {

    ZoneRestorationRecord saveRestoration(ZoneRestorationRecord record);

    ZoneRestorationRecord getRecordById(Long id);

    List<ZoneRestorationRecord> getRecordsForZone(Long zoneId);

    List<ZoneRestorationRecord> getAllRestorations();
}
