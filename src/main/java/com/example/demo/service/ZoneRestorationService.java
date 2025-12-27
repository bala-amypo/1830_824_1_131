package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationService {

    ZoneRestorationRecord restoreZone(Long zoneId);

    ZoneRestorationRecord getLatestRestoration(Long zoneId);

    List<ZoneRestorationRecord> getAllRestorations();
}
