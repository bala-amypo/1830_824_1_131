package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "load_shedding_event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Zone zone;

    @Column(nullable = false)
    private Double expectedDemandReductionMW;

    @Column(nullable = false)
    private Instant eventStart;

    private Instant eventEnd;

    private String reason;
}
