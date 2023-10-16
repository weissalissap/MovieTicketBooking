package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.HallSeat;
import com.weissa.movieTicketBooking.repositories.HallSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallSeatService {
    @Autowired

    private HallSeatRepository hallSeatRepository;

    public HallSeat save(HallSeat hallSeat) {
        return hallSeatRepository.save(hallSeat);
    }

    public List<HallSeat> getAllHallSeat() {
        return hallSeatRepository.findAll();
    }

    public HallSeat getHallSeatById(int id) {
        return hallSeatRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        hallSeatRepository.findById(id).ifPresent(hallSeat -> hallSeatRepository.delete(hallSeat));
    }
}
