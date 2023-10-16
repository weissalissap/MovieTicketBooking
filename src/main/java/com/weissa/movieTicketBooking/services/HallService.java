package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.Hall;
import com.weissa.movieTicketBooking.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    @Autowired

    private HallRepository hallRepository;

    public Hall save(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public Hall getHallById(int id) {
        return hallRepository.findById(id);
    }

    public void delete(int id) {
        Hall hall = hallRepository.findById(id);
        hallRepository.delete(hall);
    }
}
