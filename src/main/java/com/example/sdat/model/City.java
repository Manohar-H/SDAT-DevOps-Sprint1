package com.example.sdat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(0)
    private int population;

    @NotBlank
    private String state;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Airport> airports;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Passenger> residents;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }

    public List<Passenger> getResidents() { return residents; }
    public void setResidents(List<Passenger> residents) { this.residents = residents; }
}