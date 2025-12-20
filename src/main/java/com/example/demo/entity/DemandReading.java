package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double reading;

    // getters & setters
}
