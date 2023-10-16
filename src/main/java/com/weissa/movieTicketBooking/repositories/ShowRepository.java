package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    Show findById(int id);

    @Query(value = "select s.* from show_table s inner join hall h inner join theater t " +
            "on s.hall_id = h.hall_id and t.theater_id = h.theater_id  where s.show_date = ?2 and s.movie_id = ?3 and t.city_id = ?1" , nativeQuery = true)
    List<Show> findAllShowByDateAndByMovieNameAndByCity(int cityId, String showDate, int movieId);

    @Query(value = "select s.* from show_table s where s.show_date = ?1", nativeQuery = true)
    List<Show> findAllShowByDate( String showDate);

    @Query(value = "select s.* from show_table s inner join hall h inner join theater t " +
            "on s.hall_id = h.hall_id and t.theater_id = h.theater_id  where s.show_date = ?2 and t.city_id = ?1" , nativeQuery = true)
    List<Show> findAllShowByDateAndByCity(int city_id, String showDate);

    @Query(value = "select s.* from show_table s where s.movie_id = ?1", nativeQuery = true)
    List<Show> findAllShowByMovie(int movie_id);
}
