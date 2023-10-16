package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.ShowSeat;
import com.weissa.movieTicketBooking.models.Seat;
import com.weissa.movieTicketBooking.models.ShowSeatsAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    @Query(value = "select s.show_id as showId, s.show_date as showDate,h.name as hallName," +
            "t.name as theaterName, ss.count as seatCount, ss.showSeats, ss.seats as seats from show_table s inner join hall h inner join theater t " +
            "inner join (select ss.show_id,count(*) as count,GROUP_CONCAT(ss.show_seat_id) as showSeats, GROUP_CONCAT(hs.seat_number) as seats from show_seat ss inner join hall_seat hs on ss.hall_seat_id=hs.hall_seat_id  where ss.status=0 group by ss.show_id) ss " +
            "on s.hall_id = h.hall_id and t.theater_id = h.hall_id and s.show_id=ss.show_id where s.show_date = ?2 and s.movie_id = ?3 and t.city_id = ?1" , nativeQuery = true)
    List<ShowSeatsAvailable> findAllShowByDateAndByMovieNameAndByCityBySeatAvl(int cityId, String showDate, int movieId);

    @Query(value= "select show_seat_id as showSeatId from show_table s inner join show_seat ss on s.show_id = ss.show_id where s.show_id = ?1 and ss.status=0 limit ?2", nativeQuery = true)
    List<Seat> findShowByShowAndBySeatAvl(int showId, int countOfSeats);

    @Modifying
    @Transactional
    @Query(value = "update show_seat set status = 1, booking_id = ?1 where show_seat_id = ?2", nativeQuery = true)
    void updateBookings(int bookingId, int showSeatId);

    @Modifying
    @Query(value = "update show_seat set status = 0, booking_id = NULL where booking_id = ?1", nativeQuery = true)
    void cancelBookings(int bookingId);
}
