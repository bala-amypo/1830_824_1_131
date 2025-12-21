package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository SupplyForecastRepository;

    public SupplyForecastServiceImpl(SupplyForecastRepository SupplyForecastRepository) {
        this.SupplyForecastRepository = SupplyForecastRepository;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        return SupplyForecastRepository.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        SupplyForecast existing = SupplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));

        return SupplyForecastRepository.save(existing);
    }

    @Override
    public SupplyForecast getForecastById(Long id) {
        return SupplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return SupplyForecastRepository.findAll();
    }

    @Override
    public List<SupplyForecast> getLatestForecast() {
        return SupplyForecastRepository.findAll();
    }
}
