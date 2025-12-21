package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationRecordService {

    ZoneRestorationRecord restoreZone(ZoneRestorationRecord record);

    SupplyForecast updateForecast(Long id, SupplyForecast forecast);

    SupplyForecast getForecastById(Long id);

    List<SupplyForecast> getAllForecasts();

    List<SupplyForecast> getLatestForecast();
}
