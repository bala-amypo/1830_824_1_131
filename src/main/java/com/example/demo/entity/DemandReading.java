package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "demand_reading")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @NotNull
    @Min(0)
    @Column(name = "demand_mw", nullable = false)
    private Double demandMW;   // 🔥 THIS WAS MISSING

    @NotNull
    @Column(name = "recorded_at", nullable = false)
    private Instant recordedAt;
}
