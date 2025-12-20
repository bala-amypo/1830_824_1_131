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
        this.notes = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getzoneName() {
        return zoneName;
    }

    public void setzoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getpriorityLevel() {
        return priorityLevel;
    }

    public void setpriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Integer getpopulation() {
        return population;
    }

    public void sepopulation(Integer population) {
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
