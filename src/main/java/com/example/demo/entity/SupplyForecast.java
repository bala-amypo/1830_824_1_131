package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Data
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double availableSupplyMW;
    private Instant forecastStart;
    private Instant forecastEnd;
    private Instant generatedAt;
}
