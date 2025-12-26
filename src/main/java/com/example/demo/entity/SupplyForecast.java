package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "supply_forecasts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplyForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double availableSupplyMW;
    
    private Instant forecastStart;
    
    private Instant forecastEnd;
    
    private Instant generatedAt;
    
    @PrePersist
    protected void onCreate() {
        generatedAt = Instant.now();
    }
}