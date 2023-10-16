package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.HallSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallSeatRepository extends JpaRepository<HallSeat, Integer> {
}
