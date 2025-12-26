package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "supply_forecast")
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    @Column(name = "demand_mw", nullable = false)
    private Double demandMW;

    @NotNull
    @Min(0)
    @Column(name = "supply_mw", nullable = false)
    private Double supplyMW;

    @NotNull
    @Column(name = "generated_at", nullable = false)
    private LocalDateTime generatedAt;

    public SupplyForecast() {
    }

    public Long getId() {
        return id;
    }

    public Double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(Double demandMW) {
        this.demandMW = demandMW;
    }

    public Double getSupplyMW() {
        return supplyMW;
    }

    public void setSupplyMW(Double supplyMW) {
        this.supplyMW = supplyMW;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
