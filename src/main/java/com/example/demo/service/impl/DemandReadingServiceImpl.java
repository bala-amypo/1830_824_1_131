// package com.example.demo.service.impl;

// import com.example.demo.entity.DemandReading;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.DemandReadingRepository;
// import com.example.demo.service.DemandReadingService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DemandReadingServiceImpl implements DemandReadingService {

//     private final DemandReadingRepository demandReadingRepository;

//     public DemandReadingServiceImpl(DemandReadingRepository demandReadingRepository) {
//         this.demandReadingRepository = demandReadingRepository;
//     }

//     // CREATE reading
//     @Override
//     public DemandReading createReading(DemandReading reading) {
//         return demandReadingRepository.save(reading);
//     }

//     // GET all readings for zone
//     @Override
//     public List<DemandReading> getReadingsForZone(Long zoneId) {
//         List<DemandReading> readings =
//                 demandReadingRepository.findByZoneIdOrderByRecordedAtDesc(zoneId);

//         if (readings.isEmpty()) {
//             throw new ResourceNotFoundException(
//                     "No demand readings found for zone id: " + zoneId);
//         }

//         return readings;
//     }

//     // GET latest reading
//     @Override
//     public DemandReading getLatestReading(Long zoneId) {
//         return demandReadingRepository
//                 .findFirstByZoneIdOrderByRecordedAtDesc(zoneId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException(
//                                 "No latest reading found for zone id: " + zoneId));
//     }

//     // GET recent N readings
//     @Override
//     public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
//         List<DemandReading> readings =
//                 demandReadingRepository.findByZoneIdOrderByRecordedAtDesc(zoneId);

//         if (readings.isEmpty()) {
//             throw new ResourceNotFoundException(
//                     "No demand readings found for zone id: " + zoneId);
//         }

//         return readings.stream()
//                 .limit(limit)
//                 .toList();
//     }
// }

package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

    DemandReading createReading(DemandReading reading);

    List<DemandReading> getReadingsByZone(Long zoneId);

    DemandReading getLatestReading(Long zoneId);
}
