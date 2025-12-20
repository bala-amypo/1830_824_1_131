package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.Instant;

@Entity
@Table(
    name = "zones",
    uniqueConstraints = @UniqueConstraint(columnNames = "zone_name")
)
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name", nullable = false, unique = true)
    private String zoneName;

    @Min(1)
    private Integer priorityLevel;

    private Integer population;

    private Boolean active = true;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
        if (active == null) active = true;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = I
