package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Integer> {
    Hall findById(int id);
}
