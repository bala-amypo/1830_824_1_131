package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private Double demandMW;
    private Timestamp recordedAt;

    public DemandReading() {
    }

    public DemandReading(Long id, String zone, Double demandMW, Timestamp recordedAt) {
        this.id = id;
        this.zone = zone;
        this.demandMW = demandMW;
        this.recordedAt = recordedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(Double demandMW) {
        this.demandMW = demandMW;
    }

    public Timestamp getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }
}
