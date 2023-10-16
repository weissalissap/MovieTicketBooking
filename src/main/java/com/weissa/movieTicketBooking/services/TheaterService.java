package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.City;
import com.weissa.movieTicketBooking.entities.Theater;
import com.weissa.movieTicketBooking.repositories.CityRepository;
import com.weissa.movieTicketBooking.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CityRepository cityRepository;

    public Theater save(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(int id) {
        return theaterRepository.findById(id).orElse(null);
    }

    public List<Theater> getAllTheaterByCity(String cityName) {
        City city = cityRepository.findByName(cityName).orElse(null);
        List<Theater> theaterList = new ArrayList<>();
        if (city == null) return theaterList;
        return theaterRepository.findAllTheatersByCity(city.getCityId());
    }

    public Theater getTheaterByName(String name) {
        return theaterRepository.findByName(name).orElse(null);
    }

    public void delete(int id) {
        Theater theater = theaterRepository.findById(id).orElse(null);
        if (theater != null) {
            theaterRepository.delete(theater);
        }
    }
}
