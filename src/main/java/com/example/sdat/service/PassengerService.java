package com.example.sdat.service;

import com.example.sdat.model.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger passenger);
    Passenger getPassengerById(Long id);
    List<Passenger> getAllPassengers();
    Passenger updatePassenger(Long id, Passenger updatedPassenger);
    void deletePassenger(Long id);
}