package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface SupplyForecastService {

    SupplyForecast createForecast(SupplyForecast forecast);

    SupplyForecast updateForecast(Lond id,SupplyForecast forecast);

    SupplyForecast ;

    List<Zone> getAllZones();

    void deactivateZone(Long id);
}
