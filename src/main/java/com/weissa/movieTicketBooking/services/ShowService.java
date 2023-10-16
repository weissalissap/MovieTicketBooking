package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired

    private ShowRepository showRepository;

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public List<Show> getAllShow() {
        return showRepository.findAll();
    }

    public Show getShowById(int id) {
        return showRepository.findById(id);
    }

    public void delete(int id) {
        Show show = showRepository.findById(id);
        showRepository.delete(show);
    }
}
