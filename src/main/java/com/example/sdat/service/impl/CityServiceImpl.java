package com.example.sdat.service.impl;

import com.example.sdat.exception.CityNotFoundException;
import com.example.sdat.model.City;
import com.example.sdat.repository.CityRepository;
import com.example.sdat.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    // 💡 Inject CityRepository via constructor
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found with id: " + id));
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
        City city = getCity(id);
        cityRepository.delete(city);
    }
}