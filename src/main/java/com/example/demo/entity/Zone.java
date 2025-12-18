package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
public class Zone {
    private long id;
    private String zoneName;
    private Integer priorityLevel;
    private Integer population;
    private Boolean active;
    private Timestamp createAt;
    private Timestamp updatedAt;
    public long getId(int id) {
        this.id = id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String setzoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public void setzoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public Integer getpriorityLevel(Integer priorityLevel ) {
        this.priorityLevel = priorityLevel;
    }
    public void setpriorityLevel(Integer priorityLevel) {
        this.priorityLevel= priorityLevel;
    }
    public Integer getpopulation(Integer population ) {
        this.population = population;
    }
    public void setpopulation(Integer population) {
        this.population= population;
    }
    public Boolean getactive(Integer population ) {
        this.population = population;
    }
    public void setpopulation(Integer population) {
        this.population= population;
    }