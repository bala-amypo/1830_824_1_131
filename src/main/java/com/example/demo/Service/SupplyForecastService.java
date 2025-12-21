package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface SupplyForecastService {

    SupplyForecast createForecast(SupplyForecast forecast);

    SupplyForecast updateForecast(Lond id,SupplyForecast forecast);

    SupplyForecast getForecastById(Long id);

    List<SupplyForecast> getAllForecasts();

    List<SupplyForecast> getLatestForecast();
}
