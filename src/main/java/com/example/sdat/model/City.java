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

    @NotBlank
    private String name;

    @Min(1)
    private int population;

    @NotBlank
    private String state;

    //@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    //private List<Airport> airports;

    //@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    //private List<Passenger> passengers;
}