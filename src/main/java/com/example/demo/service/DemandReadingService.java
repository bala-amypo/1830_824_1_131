package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

    DemandReading createReading(DemandReading reading);

    List<DemandReading> getReadingsByZone(Long zoneId);

    DemandReading getLatestReading(Long zoneId);

    List<DemandReading> getRecentReadings(Long zoneId, int limit);
}
