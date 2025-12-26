package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "zone_restoration_record")
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private LoadSheddingEvent loadSheddingEvent;

    @NotNull
    @Column(name = "restored_at", nullable = false)
    private LocalDateTime restoredAt;

    public ZoneRestorationRecord() {
    }

    public Long getId() {
        return id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public LoadSheddingEvent getLoadSheddingEvent() {
        return loadSheddingEvent;
    }

    public void setLoadSheddingEvent(LoadSheddingEvent loadSheddingEvent) {
        this.loadSheddingEvent = loadSheddingEvent;
    }

    public LocalDateTime getRestoredAt() {
        return restoredAt;
    }

    public void setRestoredAt(LocalDateTime restoredAt) {
        this.restoredAt = restoredAt;
    }
}
