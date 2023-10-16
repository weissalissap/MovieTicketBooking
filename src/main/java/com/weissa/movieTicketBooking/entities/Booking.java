package com.weissa.movieTicketBooking.entities;

import com.weissa.movieTicketBooking.constant.Constant;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Constant.BOOKING_TABLE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    int bookingId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "show_id", nullable = false)
    Show show;
    @Column(name = "number_of_seats")
    int numberOfSeats;
    @Column(name = "status")
    int status; //0 -> started, not completed; 1 -> booking done; 2 -> booking cancelled
    @Column(name = "booked_date")
    LocalDate bookedDate;
    @Column(name = "booking_amount")
    double bookingAmount;
}
