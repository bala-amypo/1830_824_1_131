// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;

// import java.time.Instant;

// @Entity
// @Table(name = "load_shedding_events")
// public class LoadSheddingEvent {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(optional = false)
//     private Zone zone;

//     private Instant eventStart;
//     private Instant eventEnd;

//     private String reason;

//     private Long triggeredByForecastId;

//     @Min(0)
//     private Double expectedDemandReductionMW;

//     // getters & setters
// }
