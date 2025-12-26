package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "demand_reading")
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Double demandMW;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    public DemandReading() {
    }

    // 🔑 getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // IMPORTANT for tests
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(Double demandMW) {
        this.demandMW = demandMW;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
