package com.example.sdat.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String id) {
        super("City with ID " + id + " not found.");
    }
}