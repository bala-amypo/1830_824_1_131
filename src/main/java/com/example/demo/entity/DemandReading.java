package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.Instant;

@Entity
@Table(name = "demand_readings")
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Zone zone;

    @Min(0)
    private Double demandMW;

    private Instant recordedAt;

    @PrePersist
    public void validateTime() {
        if (recordedAt.isAfter(Instant.now())) {
            throw new IllegalArgumentException("recordedAt cannot be in the future");
        }
    }

    // getters & setters
}
