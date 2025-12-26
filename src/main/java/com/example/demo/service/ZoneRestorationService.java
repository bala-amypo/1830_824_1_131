package com.example.demo.service;

import com.example.demo.entity.Zone;

public interface ZoneRestorationService {

    Zone restoreZone(Long zoneId);

    Zone deactivateZone(Long zoneId);
}
