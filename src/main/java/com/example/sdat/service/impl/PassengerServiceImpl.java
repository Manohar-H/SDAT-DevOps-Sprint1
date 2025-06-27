package com.example.sdat.service.impl;

import com.example.sdat.exception.PassengerNotFoundException;
import com.example.sdat.model.Passenger;
import com.example.sdat.repository.PassengerRepository;
import com.example.sdat.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with ID: " + id));
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        Passenger existing = getPassengerById(id);
        existing.setFirstName(updatedPassenger.getFirstName());
        existing.setLastName(updatedPassenger.getLastName());
        existing.setPhoneNumber(updatedPassenger.getPhoneNumber());
        existing.setCity(updatedPassenger.getCity());
        return passengerRepository.save(existing);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.delete(getPassengerById(id));
    }
}