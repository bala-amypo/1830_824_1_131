package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Data
@Builder
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;
    private Double shedAmount;
}
