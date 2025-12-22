// package com.example.demo.service.impl;

// import com.example.demo.model.LoadSheddingEvent;
// import com.example.demo.service.LoadSheddingService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class LoadSheddingServiceImpl implements LoadSheddingService {

//     // In-memory store - works without DB
//     private final List<LoadSheddingEvent> events = new ArrayList<>();
//     private long idCounter = 1;

//     @Override
//     public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

//         LoadSheddingEvent event = new LoadSheddingEvent();
//         event.setId(idCounter++);
//         event.setForecastId(forecastId);
//         event.setTriggeredAt(LocalDateTime.now());
//         event.setStatus("TRIGGERED");

//         events.add(event);

//         return event;
//     }

//     @Override
//     public LoadSheddingEvent getEventById(Long id) {
//         return events.stream()
//                 .filter(e -> e.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
//         // No zone filtering → return all instead
//         return new ArrayList<>(events);
//     }

//     @Override
//     public List<LoadSheddingEvent> getAllEvents() {
//         return new ArrayList<>(events);
//     }
// }
