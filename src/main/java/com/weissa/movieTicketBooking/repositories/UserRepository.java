package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);

}
