package com.example.sdat.service.impl;

import com.example.sdat.exception.AirportNotFoundException;
import com.example.sdat.model.Airport;
import com.example.sdat.repository.AirportRepository;
import com.example.sdat.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport updateAirport(Long id, Airport updatedAirport) {
        Airport airport = getAirportById(id);
        airport.setName(updatedAirport.getName());
        airport.setCode(updatedAirport.getCode());
        airport.setCity(updatedAirport.getCity());
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}