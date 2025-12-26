package com.example.demo.controller;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.service.SupplyForecastService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/supply-forecasts")
@Tag(name = "Supply Forecast Management", description = "APIs for managing power supply forecasts")
public class SupplyForecastController {
    
    private final SupplyForecastService forecastService;
    
    public SupplyForecastController(SupplyForecastService forecastService) {
        this.forecastService = forecastService;
    }
    
    @PostMapping
    public ResponseEntity<SupplyForecast> createForecast(@RequestBody SupplyForecast forecast) {
        return ResponseEntity.ok(forecastService.createForecast(forecast));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SupplyForecast> updateForecast(@PathVariable Long id, @RequestBody SupplyForecast forecast) {
        return ResponseEntity.ok(forecastService.updateForecast(id, forecast));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SupplyForecast> getForecast(@PathVariable Long id) {
        return ResponseEntity.ok(forecastService.getForecastById(id));
    }
    
    @GetMapping("/latest")
    public ResponseEntity<SupplyForecast> getLatestForecast() {
        return ResponseEntity.ok(forecastService.getLatestForecast());
    }
    
    @GetMapping
    public ResponseEntity<List<SupplyForecast>> getAllForecasts() {
        return ResponseEntity.ok(forecastService.getAllForecasts());
    }
}