package com.example.collectiondb.entity;

import jakarta.
@entity
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
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhno(String phno) {
        this.phno = phno;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    
}
