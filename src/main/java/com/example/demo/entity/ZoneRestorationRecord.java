package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String zone;

    private TimeStamp restoredAt;
    private Long eventId;
    private String notes;

    

    public Zone() {
    }

    public Zone(Long id, String zone,TimeStamp restoredAt , Long eventId,String notes) {
        this.id = id;
        this.zone = zone;
        this.restoredAt = restoredAt;
        this.population = population;
        this.eventId = eventId;
        this.notes = notes;
        
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

    public TimeStamp getrestoredAt() {
        return restoredAt;
    }

    public void setrestoredAt(TimeStamp restoredAt) {
        this.restoredAt = restoredAt;
    }

    public Long geteventId() {
        return eventId;
    }

    public void seteventIdlleventId) {
        this.population = population;
    }

    public Boolean getactive() {
        return active;
    }

    public void setactive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
