// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// import java.sql.Timestamp;

// @Entity
// public class LoadSheddingEvent {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String zone;
//     private String reason;

//     private Timestamp eventStart;
//     private Timestamp eventEnd;

//     private Long triggeredByForecastId;

//     private Double expectedDemandReductionMW;

//     // ✅ No-args constructor (required by JPA)
//     public LoadSheddingEvent() {
//     }

//     // ✅ All-args constructor
//     public LoadSheddingEvent(
//             Long id,
//             Double expectedDemandReductionMW,
//             Timestamp eventStart,
//             Timestamp eventEnd,
//             String zone,
//             String reason,
//             Long triggeredByForecastId
//     ) {
//         this.id = id;
//         this.expectedDemandReductionMW = expectedDemandReductionMW;
//         this.eventStart = eventStart;
//         this.eventEnd = eventEnd;
//         this.zone = zone;
//         this.reason = reason;
//         this.triggeredByForecastId = triggeredByForecastId;
//     }

//     // ✅ Getters & Setters (Java standard naming)

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getZone() {
//         return zone;
//     }

//     public void setZone(String zone) {
//         this.zone = zone;
//     }

//     public String getReason() {
//         return reason;
//     }

//     public void setReason(String reason) {
//         this.reason = reason;
//     }

//     public Timestamp getEventStart() {
//         return eventStart;
//     }

//     public void setEventStart(Timestamp eventStart) {
//         this.eventStart = eventStart;
//     }

//     public Timestamp getEventEnd() {
//         return eventEnd;
//     }

//     public void setEventEnd(Timestamp eventEnd) {
//         this.eventEnd = eventEnd;
//     }

//     public Long getTriggeredByForecastId() {
//         return triggeredByForecastId;
//     }

//     public void setTriggeredByForecastId(Long triggeredByForecastId) {
//         this.triggeredByForecastId = triggeredByForecastId;
//     }

//     public Double getExpectedDemandReductionMW() {
//         return expectedDemandReductionMW;
//     }

//     public void setExpectedDemandReductionMW(Double expectedDemandReductionMW) {
//         this.expectedDemandReductionMW = expectedDemandReductionMW;
//     }
// }
