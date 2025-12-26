package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private Integer priorityLevel;
    private Long population;
    private Boolean active;

    private Instant createdAt;
    private Instant updatedAt;
}
