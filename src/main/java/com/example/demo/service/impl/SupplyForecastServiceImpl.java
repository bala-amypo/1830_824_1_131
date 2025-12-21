package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository supplyForecastRepository;

    public SupplyForecastServiceImpl(SupplyForecastRepository supplyForecastRepository) {
        this.supplyForecastRepository = supplyForecastRepository;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        return supplyForecastRepository.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        SupplyForecast existing = supplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));
        return supplyForecastRepository.save(existing);
    }

    @Override
    public SupplyForecast getForecastById(Long id) {
        return supplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return supplyForecastRepository.findAll();
    }

    @Override
    public List<SupplyForecast> getLatestForecast() {
        return supplyForecastRepository.findAll();
    }
}
