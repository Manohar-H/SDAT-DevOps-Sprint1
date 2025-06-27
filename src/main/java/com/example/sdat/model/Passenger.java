package com.example.sdat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircrafts;

    @ManyToMany
    @JoinTable(
            name = "passenger_airport",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airportsUsed;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Aircraft> getAircrafts() { return aircrafts; }
    public void setAircrafts(List<Aircraft> aircrafts) { this.aircrafts = aircrafts; }

    public List<Airport> getAirportsUsed() { return airportsUsed; }
    public void setAirportsUsed(List<Airport> airportsUsed) { this.airportsUsed = airportsUsed; }
}