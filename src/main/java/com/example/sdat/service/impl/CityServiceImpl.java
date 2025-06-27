package com.example.sdat.service.impl;

import com.example.sdat.exception.CityNotFoundException;
import com.example.sdat.model.City;
import com.example.sdat.repository.CityRepository;
import com.example.sdat.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, City city) {
        City existing = getCity(id);
        existing.setName(city.getName());
        existing.setPopulation(city.getPopulation());
        existing.setState(city.getState());
        return cityRepository.save(existing);
    }

    @Override
    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new CityNotFoundException(id);
        }
        cityRepository.deleteById(id);
    }
}