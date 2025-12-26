package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DemandReadingService {

    DemandReading create(DemandReading reading);

    List<DemandReading> getByZone(Long zoneId);

    DemandReading getLatestByZone(Long zoneId);

    Page<DemandReading> getPagedByZone(Long zoneId, int page, int size);
}
