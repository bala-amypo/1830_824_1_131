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
    public void setName() {
        this.id = id;
    }
    public void setName(String name) {
        this.zoneName = zoneName;
    }