package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Data
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Zone zone;

    private Double demandMW;
    private Instant recordedAt;
}
