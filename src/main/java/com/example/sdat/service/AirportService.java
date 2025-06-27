package com.example.sdat.service;

import com.example.sdat.model.Airport;

import java.util.List;

public interface AirportService {
    Airport createAirport(Airport airport);
    Airport getAirportById(Long id);
    List<Airport> getAllAirports();
    Airport updateAirport(Long id, Airport airport);
    void deleteAirport(Long id);
}