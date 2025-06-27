package com.example.sdat.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id) {
        super("City with ID " + id + " not found.");
    }
}