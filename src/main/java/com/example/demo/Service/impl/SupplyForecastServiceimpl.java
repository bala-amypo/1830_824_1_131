package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
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
        SupplyForecast existingForecast = supplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found with id: " + id));

        // Update fields (example)
        existingForecast.setProductName(forecast.getProductName());
        existingForecast.setQuantity(forecast.getQuantity());
        existingForecast.setForecastDate(forecast.getForecastDate());

        return supplyForecastRepository.save(existingForecast);
    }

    @Override
    public SupplyForecast getForecastById(Long id) {
        return supplyForecastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found with id: " + id));
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return supplyForecastRepository.findAll();
    }

    @Override
    public List<SupplyForecast> getLatestForecast() {
        return supplyForecastRepository.findTop1ByOrderByCreatedAtDesc();
    }
}
