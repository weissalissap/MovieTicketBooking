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
@Table(name = Constant.PAYMENT_TABLE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    int paymentId;
    @Column(name = "amount")
    int amount;
    @Column(name = "timestamp")
    LocalDate timestamp;
    @Column(name = "payment_method")
    int paymentMethod;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    Booking booking;

}
