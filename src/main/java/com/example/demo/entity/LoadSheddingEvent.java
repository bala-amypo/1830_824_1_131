package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "load_shedding_event")
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "forecast_id", nullable = false)
    private SupplyForecast forecast;

    @NotNull
    @Column(name = "event_start", nullable = false)
    private LocalDateTime eventStart;

    @NotNull
    @Column(name = "event_end", nullable = false)
    private LocalDateTime eventEnd;

    public LoadSheddingEvent() {
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

    public SupplyForecast getForecast() {
        return forecast;
    }

    public void setForecast(SupplyForecast forecast) {
        this.forecast = forecast;
    }

    public LocalDateTime getEventStart() {
        return eventStart;
    }

    public void setEventStart(LocalDateTime eventStart) {
        this.eventStart = eventStart;
    }

    public LocalDateTime getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(LocalDateTime eventEnd) {
        this.eventEnd = eventEnd;
    }
}
