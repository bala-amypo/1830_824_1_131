package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

DemandReading save(DemandReading demandReading);
List<DemandReading> getByZoneId(Long zoneId);
DemandReading getLatestReading(Long zoneId);
Page<DemandReading> getByZoneIdPaged(Long zoneId, int page, int size);

}
