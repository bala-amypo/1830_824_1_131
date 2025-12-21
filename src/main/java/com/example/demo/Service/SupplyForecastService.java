package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface  {

    Zone createZone(Zone zone);

    Zone updateZone(Long id, Zone zone);

    Zone getZoneById(Long id);

    List<Zone> getAllZones();

    void deactivateZone(Long id);
}
