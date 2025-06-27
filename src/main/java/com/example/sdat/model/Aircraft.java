package com.example.sdat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String airlineName;

    @Min(1)
    private int numberOfPassengers;

    @ManyToMany(mappedBy = "aircrafts")
    private List<Passenger> passengers;

    @ManyToMany
    @JoinTable(
            name = "aircraft_airport",
            joinColumns = @JoinColumn(name = "aircraft_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airportsUsed;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }

    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }

    public List<Airport> getAirportsUsed() { return airportsUsed; }
    public void setAirportsUsed(List<Airport> airportsUsed) { this.airportsUsed = airportsUsed; }
}