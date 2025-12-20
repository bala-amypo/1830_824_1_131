package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String zone;

    private Timestamp restoredAt;
    private Long eventId;
    private String notes;

    // No-arg constructor (required by JPA)
    public ZoneRestorationRecord() {
    }

    // Parameterized constructor
    public ZoneRestorationRecord(Long id, String zone, Timestamp restoredAt, Long eventId, String notes) {
        this.id = id;
        this.zone = zone;
        this.restoredAt = restoredAt;
        this.eventId = eventId;
        this.notes = notes;
    }

    // Getters and Setters

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

    public Timestamp getRestoredAt() {
        return restoredAt;
    }

    public void setRestoredAt(Timestamp restoredAt) {
        this.restoredAt = restoredAt;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
