package com.weissa.movieTicketBooking.entities;

import com.weissa.movieTicketBooking.constant.Constant;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Constant.SHOW_SEAT_TABLE)
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_seat_id")
    int showSeatId;
    @Column(name = "status")
    int status; //0-> available, 1-> Not available
    @Column(name = "price")
    int price;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hall_seat_id", nullable = false)
    HallSeat hallSeat;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "show_id", nullable = false)
    Show show;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    Booking booking;
}
