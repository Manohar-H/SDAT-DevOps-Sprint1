package com.example.sdat.controller;

import com.example.sdat.model.Aircraft;
import com.example.sdat.service.AircraftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraft(@PathVariable Long id) {
        Aircraft aircraft = aircraftService.getAircraft(id);
        return ResponseEntity.ok(aircraft);
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@Valid @RequestBody Aircraft aircraft) {
        Aircraft created = aircraftService.createAircraft(aircraft);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @Valid @RequestBody Aircraft aircraft) {
        Aircraft updated = aircraftService.updateAircraft(id, aircraft);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
        return ResponseEntity.noContent().build();
    }
}