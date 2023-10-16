package com.weissa.movieTicketBooking.exception;

public class BookingExceptions {

    public static class SeatNotFoundException extends RuntimeException {
        public SeatNotFoundException(String message) {
            super(message);
        }
    }
}
