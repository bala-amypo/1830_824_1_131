// package com.example.demo.service.impl;

// import com.example.demo.entity.Zone;
// import com.example.demo.repository.ZoneRepository;
// import com.example.demo.service.ZoneService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class ZoneServiceImpl implements ZoneService {

//     private final ZoneRepository zoneRepository;

//     public ZoneServiceImpl(ZoneRepository zoneRepository) {
//         this.zoneRepository = zoneRepository;
//     }

//     @Override
//     public Zone createZone(Zone zone) {
//         zone.setactive(true);
//         zone.setcreatedAt(LocalDateTime.now());
//         zone.setupdatedAt(LocalDateTime.now());
//         return zoneRepository.save(zone);
//     }

//     @Override
//     public Zone updateZone(Long id, Zone zone) {
//         Zone existingZone = zoneRepository.findById(id).orElse(null);

//         existingZone.setzoneName(zone.getzoneName());
//         existingZone.setpriorityLevel(zone.getpriorityLevel());
//         existingZone.sepopulation(zone.getpopulation());
//         existingZone.setupdatedAt(LocalDateTime.now());

//         return zoneRepository.save(existingZone);
//     }

//     @Override
//     public Zone getZoneById(Long id) {
//         return zoneRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<Zone> getAllZones() {
//         return zoneRepository.findAll();
//     }

//     @Override
//     public void deactivateZone(Long id) {
//         Zone zone = zoneRepository.findById(id).orElse(null);
//         zone.setactive(false);
//         zone.setupdatedAt(LocalDateTime.now());
//         zoneRepository.save(zone);
//     }
// }
