package com.example.sdat.service.impl;

import com.example.sdat.model.Airport;
import com.example.sdat.model.Passenger;
import com.example.sdat.model.Aircraft;
import com.example.sdat.repository.AirportRepository;
import com.example.sdat.repository.CityRepository;
import com.example.sdat.repository.PassengerRepository;
import com.example.sdat.repository.AircraftRepository;
import com.example.sdat.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QueryServiceImpl implements QueryService {

    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;
    private final PassengerRepository passengerRepository;
    private final AircraftRepository aircraftRepository;

    @Autowired
    public QueryServiceImpl(AirportRepository airportRepository,
                            CityRepository cityRepository,
                            PassengerRepository passengerRepository,
                            AircraftRepository aircraftRepository) {
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
        this.passengerRepository = passengerRepository;
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public Map<String, List<String>> getAirportsByCity() {
        Map<String, List<String>> result = new HashMap<>();

        cityRepository.findAll().forEach(city -> {
            List<String> airports = city.getAirports().stream()
                    .map(Airport::getName)
                    .collect(Collectors.toList());
            result.put(city.getName(), airports);
        });

        System.out.println("[DEBUG] getAirportsByCity: " + result);
        return result;
    }

    @Override
    public Map<String, List<String>> getAircraftByPassenger() {
        Map<String, List<String>> result = passengerRepository.findAll().stream()
                .collect(Collectors.toMap(
                        p -> p.getFirstName() + " " + p.getLastName(),
                        p -> p.getAircraft().stream()
                                .map(a -> a.getAirlineName() + " - " + a.getType())
                                .collect(Collectors.toList())
                ));

        System.out.println("[DEBUG] getAircraftByPassenger: " + result);
        return result;
    }

    @Override
    public Map<String, List<String>> getAirportsByAircraft() {
        return aircraftRepository.findAll().stream()
                .collect(Collectors.toMap(
                        a -> a.getAirlineName() + " - " + a.getType(),
                        a -> a.getOperatedAirports().stream().map(Airport::getName).collect(Collectors.toList())
                ));
    }

    @Override
    public Map<String, List<String>> getAirportsUsedByPassenger() {
        return passengerRepository.findAll().stream()
                .collect(Collectors.toMap(
                        p -> p.getFirstName() + " " + p.getLastName(),
                        p -> p.getVisitedAirports().stream().map(Airport::getName).distinct().collect(Collectors.toList())
                ));
    }
}