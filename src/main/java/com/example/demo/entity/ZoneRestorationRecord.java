package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zone;
    private Timestamp restoredAt;
    private Long eventId;
    private String notes;


    public ZoneRestorationRecord() {
    }

    public ZoneRestorationRecord(Long id, String zone, Double demandMW, Timestamp recordedAt) {
        this.id = id;
        this.zone = zone;
        this.eventId = eventId;
        this.restoredAt = restoredAt;
        this.notes=notes;
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

    public Timestamp getrestoredAt() {
        return restoredAt;
    }

    public void setrestoredAt(Timestamp restoredAt) {
        this.restoredAt = restoredAt;
    }

    public Long geteventId() {
        return eventId;
    }

    public void seteventId(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }
}
