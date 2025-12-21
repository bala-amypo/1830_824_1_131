// package com.example.demo.controller;

// import com.example.demo.entity.SupplyForecast;
// import com.example.demo.service.SupplyForecastService;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// @RestController
// @RequestMapping("/api/supply-forecasts")
// public class SupplyForecastController {

//     private final SupplyForecastService supplyForecastService;

//     public SupplyForecastController(SupplyForecastService supplyForecastService) {
//         this.supplyForecastService = supplyForecastService;
//     }

//     // POST /api/supply-forecasts
//     @PostMapping
//     public ResponseEntity<SupplyForecast> createForecast(
//             @RequestBody SupplyForecast forecast) {
//         return ResponseEntity.ok(
//                 supplyForecastService.createForecast(forecast)
//         );
//     }

//     // PUT /api/supply-forecasts/{id}
//     @PutMapping("/{id}")
//     public ResponseEntity<SupplyForecast> updateForecast(
//             @PathVariable Long id,
//             @RequestBody SupplyForecast forecast) {
//         return ResponseEntity.ok(
//                 supplyForecastService.updateForecast(id, forecast)
//         );
//     }

//     // GET /api/supply-forecasts/{id}
//     @GetMapping("/{id}")
//     public ResponseEntity<SupplyForecast> getForecastById(
//             @PathVariable Long id) {
//         return ResponseEntity.ok(
//                 supplyForecastService.getForecastById(id)
//         );
//     }

//     // GET /api/supply-forecasts/latest
//     @GetMapping("/latest")
//     public ResponseEntity<List<SupplyForecast>> getLatestForecast() {
//         return ResponseEntity.ok(
//                 supplyForecastService.getLatestForecast()
//         );
//     }

//     // GET /api/supply-forecasts
//     @GetMapping
//     public ResponseEntity<List<SupplyForecast>> getAllForecasts() {
//         return ResponseEntity.ok(
//                 supplyForecastService.getAllForecasts()
//         );
//     }
// }
