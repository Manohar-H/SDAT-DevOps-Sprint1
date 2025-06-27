package com.example.sdat.service.impl;

import com.example.sdat.exception.AircraftNotFoundException;
import com.example.sdat.model.Aircraft;
import com.example.sdat.repository.AircraftRepository;
import com.example.sdat.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Aircraft getAircraft(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException("Aircraft not found with ID: " + id));
    }

    @Override
    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        Aircraft aircraft = getAircraft(id);
        aircraft.setType(updatedAircraft.getType());
        aircraft.setAirlineName(updatedAircraft.getAirlineName());
        aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteAircraft(Long id) {
        Aircraft aircraft = getAircraft(id);
        aircraftRepository.delete(aircraft);
    }
}