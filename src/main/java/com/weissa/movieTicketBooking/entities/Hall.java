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
@Table(name = Constant.HALL_TABLE)
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_id")
    int hallId;
    @Column(name = "name")
    String name;
    @Column(name = "number_of_seats")
    int totalSeats;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    Theater theater;
}
