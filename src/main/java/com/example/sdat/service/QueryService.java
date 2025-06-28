package com.example.sdat.service;

import java.util.List;
import java.util.Map;

public interface QueryService {

    // 1. What airports are there in each city?
    Map<String, List<String>> getAirportsByCity();

    // 2. What aircraft has each passenger flown on?
    Map<String, List<String>> getAircraftByPassenger();

    // 3. What airports do aircraft take off from and land at?
    Map<String, List<String>> getAirportsByAircraft();

    // 4. What airports have passengers used?
    Map<String, List<String>> getAirportsUsedByPassenger();
}