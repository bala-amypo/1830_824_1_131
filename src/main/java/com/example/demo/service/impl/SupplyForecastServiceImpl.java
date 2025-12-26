package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository repo;

    public SupplyForecastServiceImpl(SupplyForecastRepository repo) {
        this.repo = repo;
    }

    // ---------------- CREATE ----------------
    @Override
    public SupplyForecast createForecast(SupplyForecast f) {

        if (f.getAvailableSupplyMW() == null || f.getAvailableSupplyMW() < 0) {
            throw new BadRequestException("Supply must be >= 0");
        }

        if (f.getForecastStart() == null || f.getForecastEnd() == null ||
                !f.getForecastEnd().isAfter(f.getForecastStart())) {
            throw new BadRequestException("Invalid forecast range");
        }

        return repo.save(f);
    }

    // ---------------- UPDATE ----------------
    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast input) {

        SupplyForecast existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Forecast not found")
                );

        if (input.getAvailableSupplyMW() != null) {
            if (input.getAvailableSupplyMW() < 0) {
                throw new BadRequestException("Supply must be >= 0");
            }
            existing.setAvailableSupplyMW(input.getAvailableSupplyMW());
        }

        if (input.getForecastStart() != null && input.getForecastEnd() != null) {
            if (!input.getForecastEnd().isAfter(input.getForecastStart())) {
                throw new BadRequestException("Invalid forecast range");
            }
            existing.setForecastStart(input.getForecastStart());
            existing.setForecastEnd(input.getForecastEnd());
        }

        return repo.save(existing);
    }

    // ---------------- GET LATEST ----------------
    @Override
    public SupplyForecast getLatestForecast() {
        return repo.findFirstByOrderByGeneratedAtDesc()
                .orElseThrow(() ->
                        new ResourceNotFoundException("No forecasts found")
                );
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repo.findAll();
    }
}
