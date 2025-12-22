package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String zone;

    private Timestamp eventStart ;
    private Timestamp eventEnd;
    private String reason;

    private Long triggeredForecastId;
    private Double expectedDemandReductionMW;

    // -------- Constructors --------

    public LoadSheddingEvent() {
    }

    public LoadSheddingEvent(Long id, String zone, Timestamp eventStart, Timestamp eventEnd,
                String reason, Long triggeredForecastId, Double expectedDemandReductionMW) {
        this.id = id;
        this.zone = zone;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.reason = reason;
        this.triggeredForecastId = triggeredForecastId;
        this.expectedDemandReductionMW = expectedDemandReductionMW;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getzone() {
        return zone;
    }

    public void setzone(String zone) {
        this.zone = zone;
    }

    public Timestamp geteventStart() {
        return eventStart;
    }

    public void seteventStart( Timestamp eventStart) {
        this.eventStart = eventStart;
    }

    public Timestamp geteventEnd() {
        return eventEnd;
    }

    public void seteventEnd(Timestamp eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getreason() {
        return reason;
    }

    public void setreason(String reason) {
        this.reason = reason;
    }

    public Long gettriggeredForecastId () {
        return triggeredForecastId;
    }

    public void settriggeredForecastId (Long triggeredForecastId ) {
        this.triggeredForecastId = triggeredForecastId ;
    }

    public LocalDateTime getexpectedDemandReductionMW() {
        return updatedAt;
    }

    public void setexpectedDemandReductionMW(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
