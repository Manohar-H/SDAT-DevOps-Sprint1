package com.example.sdat.controller;

import com.example.sdat.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/queries")
public class QueryController {

    private final QueryService queryService;

    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    // 1. What airports are there in each city?
    @GetMapping("/airports-by-city")
    public Map<String, List<String>> getAirportsByCity() {
        return queryService.getAirportsByCity();
    }

    // 2. What aircraft has each passenger flown on?
    @GetMapping("/aircrafts-by-passenger")
    public Map<String, List<String>> getAircraftsByPassenger() {
        return queryService.getAircraftsByPassenger();
    }

    // 3. What airports do aircraft take off from and land at?
    @GetMapping("/airports-by-aircraft")
    public Map<String, List<String>> getAirportsByAircraft() {
        return queryService.getAirportsByAircraft();
    }

    // 4. What airports have passengers used?
    @GetMapping("/airports-used-by-passenger")
    public Map<String, List<String>> getAirportsUsedByPassenger() {
        return queryService.getAirportsUsedByPassenger();
    }
}