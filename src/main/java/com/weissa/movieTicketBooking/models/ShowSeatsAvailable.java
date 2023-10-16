package com.weissa.movieTicketBooking.models;

import java.time.LocalDate;

public interface ShowSeatsAvailable {

    Integer getShowId();
    LocalDate getShowDate();
    String getHallName();
    String getTheaterName();
    Integer getSeatCount();
    String getShowSeats();
    String getSeats();
}
