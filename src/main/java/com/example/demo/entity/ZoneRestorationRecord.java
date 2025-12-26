package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "zone_restoration_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZoneRestorationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
    
    private Instant restoredAt;
    
    private Long eventId;
    
    private String notes;
}