package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.Booking;
import com.weissa.movieTicketBooking.entities.ShowSeat;
import com.weissa.movieTicketBooking.models.Seat;
import com.weissa.movieTicketBooking.repositories.BookingRepository;
import com.weissa.movieTicketBooking.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShowSeatService {
    @Autowired

    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ShowSeat save(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    public List<ShowSeat> getAllShowSeat() {
        return showSeatRepository.findAll();
    }

    public ShowSeat getShowSeatById(int id) {
        return showSeatRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        showSeatRepository.findById(id).ifPresent(showSeat -> showSeatRepository.delete(showSeat));
    }

    public List<Seat> getAvailableSeats(int showId, int countOfSeats) {
        return showSeatRepository.findShowByShowAndBySeatAvl(showId, countOfSeats);
    }

    public void updateBooking(int bookingId, int showSeatId){
        showSeatRepository.updateBookings(bookingId, showSeatId);
    }

    public Booking commitBookingWithSeatNumList(int bookingId, List<Integer> seatList){
        return commitBooking(bookingId, seatList);
    }

    public Booking commitBookingWithSeatList(int bookingId, List<Seat> seatList){
        List<Integer> seats = seatList.stream().map(Seat::getShowSeatId).collect(Collectors.toList());
        return commitBooking(bookingId, seats);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking commitBooking(int bookingId, List<Integer> seatList){
        double bookingAmount=0;
        for(int seat : seatList){
            bookingAmount += Objects.requireNonNull(showSeatRepository.findById(seat).orElse(null)).getPrice();
            showSeatRepository.updateBookings(bookingId, seat);
        }
        bookingRepository.updateBookingStatusAndAmount(bookingId,bookingAmount);
        return bookingRepository.findById(bookingId).orElse(null);
    }


    public boolean checkSeatAvailable(List<Integer> seatList){
        boolean available = false;
        for(int seat : seatList){
            if(Objects.requireNonNull(showSeatRepository.findById(seat).orElse(null)).getStatus()!=0){
                return false;
            }
            else available = true;
        }
        return available;
    }
}
