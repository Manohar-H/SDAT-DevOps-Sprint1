package com.example.sdat.exception;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(Long id) {
        super("Airport not found with id: " + id);
    }
}