package com.example.sdat.service;

import com.example.sdat.model.Aircraft;

import java.util.List;

public interface AircraftService {
    Aircraft getAircraft(Long id);
    List<Aircraft> getAllAircraft();
    Aircraft createAircraft(Aircraft aircraft);
    Aircraft updateAircraft(Long id, Aircraft aircraft);
    void deleteAircraft(Long id);
}