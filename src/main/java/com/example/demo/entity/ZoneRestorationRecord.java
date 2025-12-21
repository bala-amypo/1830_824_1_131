// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity

// public class ZoneRestorationRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long zoneId;   // ✅ MUST EXIST

//     public ZoneRestorationRecord() {}

//     public ZoneRestorationRecord(Long id, Long zoneId) {
//         this.id = id;
//         this.zoneId = zoneId;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getZoneId() {
//         return zoneId;
//     }

//     public void setZoneId(Long zoneId) {
//         this.zoneId = zoneId;
//     }
// }
