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
    private Boolean address;
    public long getId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.zoneName = zoneName;
    }
    public void setEmail(String email) {
        this.priority = email;
    }
    public void setPhno(String phno) {
        this.phno = phno;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    
}
