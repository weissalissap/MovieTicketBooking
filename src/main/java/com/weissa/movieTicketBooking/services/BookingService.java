package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.Booking;
import com.weissa.movieTicketBooking.repositories.BookingRepository;
import com.weissa.movieTicketBooking.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    EntityManager entityManager;

    public BookingService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public int saveBooking(Booking booking){
        entityManager.persist(booking);
        return booking.getBookingId();
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        bookingRepository.findById(id).ifPresent(booking -> bookingRepository.delete(booking));
    }

    @Transactional
    public void updateBookingStatus(int id, double amount){
        bookingRepository.updateBookingStatusAndAmount(id,amount);
    }

    @Transactional
    public void cancelBooking(int id){
        bookingRepository.cancelBooking(id);
        showSeatRepository.cancelBookings(id);
    }
}
