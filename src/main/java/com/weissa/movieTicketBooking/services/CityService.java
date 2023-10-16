package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.City;
import com.weissa.movieTicketBooking.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityByName(String cityName) {
        return cityRepository.findByName(cityName).orElse(null);
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElse(null);
    }
}
