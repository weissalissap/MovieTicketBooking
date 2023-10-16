package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(int id);
    Movie findByMovieName(String name);
}
