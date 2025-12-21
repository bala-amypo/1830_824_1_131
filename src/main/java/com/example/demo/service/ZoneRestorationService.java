package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationRecordService {

    ZoneRestorationRecord restoreZone(ZoneRestorationRecord record);

    ZoneRestorationRecord getRecordById(Long id);

    ZoneRestorationRecord getForecastById(Long id);

    List<SupplyForecast> getAllForecasts();

    List<SupplyForecast> getLatestForecast();
}
