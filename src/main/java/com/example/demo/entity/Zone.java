package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name", nullable = false, unique = true)
    private String zoneName;

    @NotNull
    @Min(0)
    @Column(name = "load_mw", nullable = false)
    private Double loadMW;

    @NotNull
    @Column(nullable = false)
    private Boolean active = true;

    @NotNull
    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    public Zone() {
    }

    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Double getLoadMW() {
        return loadMW;
    }

    public void setLoadMW(Double loadMW) {
        this.loadMW = loadMW;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
