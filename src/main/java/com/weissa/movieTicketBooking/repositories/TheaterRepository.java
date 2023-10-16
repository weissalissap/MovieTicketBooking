package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Optional<Theater> findByName(String name);

    @Query(value = "select * from Theater t where t.city_id = ?1 ", nativeQuery = true)
    List<Theater> findAllTheatersByCity(int cityId);
}
