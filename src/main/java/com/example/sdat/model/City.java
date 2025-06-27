package com.example.sdat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private int population;

    //@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    //private List<Airport> airports;

    //@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    //private List<Passenger> passengers;
}