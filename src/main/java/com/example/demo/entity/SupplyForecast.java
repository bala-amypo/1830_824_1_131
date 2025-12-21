// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;

// import java.time.Instant;

// @Entity
// @Table(name = "supply_forecasts")
// public class SupplyForecast {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Min(0)
//     private Double availableSupplyMW;

//     private Instant forecastStart;
//     private Instant forecastEnd;

//     private Instant generatedAt;

//     @PrePersist
//     public void onGenerate() {
//         generatedAt = Instant.now();
//     }

//     // getters & setters
// }
