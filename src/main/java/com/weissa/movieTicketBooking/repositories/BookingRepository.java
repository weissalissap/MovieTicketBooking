package com.weissa.movieTicketBooking.repositories;

import com.weissa.movieTicketBooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update booking set status=1, booking_amount = ?2 where booking_id = ?1", nativeQuery = true)
    //put status as 1 for booking confirmation
    void updateBookingStatusAndAmount(int bookingId, double amount);

    @Modifying
    @Transactional
    @Query(value = "update booking set status=2 where booking_id = ?1", nativeQuery = true)
    //put status as 2 for cancellation
    void cancelBooking(int bookingId);
}
