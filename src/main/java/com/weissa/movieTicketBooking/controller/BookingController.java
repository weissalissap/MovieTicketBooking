package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Booking;
import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.entities.User;
import com.weissa.movieTicketBooking.exception.BookingExceptions;
import com.weissa.movieTicketBooking.models.Seat;
import com.weissa.movieTicketBooking.models.SeatRequest;
import com.weissa.movieTicketBooking.services.BookingService;
import com.weissa.movieTicketBooking.services.ShowSeatService;
import com.weissa.movieTicketBooking.services.ShowService;
import com.weissa.movieTicketBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = Constant.BOOKING_CONTROLLER_REQUEST)
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private ShowService showService;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody Booking getBookingById(@PathVariable final Integer Id) {
        return bookingService.getBookingById(Id);
    }


    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<Booking> getAllBookings() {
        return bookingService.getAllBooking();
    }

    @PostMapping(value = "/new/user/{userId}/show/{showId}/count/{countOfSeats}")
    public @ResponseBody Booking doBookingNonSelective(@PathVariable final Integer userId, @PathVariable final Integer showId, @PathVariable final Integer countOfSeats) {
        Booking booking = new Booking();
        List<Seat> listSeats = showSeatService.getAvailableSeats(showId,countOfSeats);
        if(listSeats.size()>=countOfSeats){
            //apply row level locking
            Show show = showService.getShowById(showId);
            User user = userService.getUserById(userId);
            booking.setShow(show);
            booking.setUser(user);
            booking.setNumberOfSeats(countOfSeats);
            booking.setBookedDate(LocalDate.now());
            int initiatedBookingId  = bookingService.saveBooking(booking);
            return showSeatService.commitBookingWithSeatList(initiatedBookingId, listSeats);
        }
        else throw new BookingExceptions.SeatNotFoundException("Seats not available");
    }

    @PostMapping(value = "/new")
    public @ResponseBody Booking doBooking(@RequestBody SeatRequest seatRequest) {
        Booking booking = new Booking();
        boolean check = showSeatService.checkSeatAvailable(seatRequest.getShowSeatIdList());
        if(check){
            //apply row level locking
            Show show = showService.getShowById(seatRequest.getShowId());
            User user = userService.getUserById(seatRequest.getUserId());
            booking.setShow(show);
            booking.setUser(user);
            booking.setNumberOfSeats(seatRequest.getShowSeatIdList().size());
            booking.setBookedDate(LocalDate.now());
            int initiatedBookingId  = bookingService.saveBooking(booking);
            return showSeatService.commitBookingWithSeatNumList(initiatedBookingId, seatRequest.getShowSeatIdList());
        }
        else throw new BookingExceptions.SeatNotFoundException("Seats not available");
    }

    @PostMapping(value = "/cancel/{Id}")
    public @ResponseBody void cancelBooking(@PathVariable final Integer Id){
        bookingService.cancelBooking(Id);
    }


}
