package com.weissa.movieTicketBooking.entities;

import com.weissa.movieTicketBooking.constant.Constant;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Constant.SHOW_TABLE)
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    int showId;
    @Column(name = "show_date")
    LocalDate showDate;
    @Column(name = "start_time")
    LocalDateTime startTime;
    @Column(name = "end_time")
    LocalDateTime endTime;
    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.MERGE)
    @JoinColumn(name = "movie_id", nullable = false)
    Movie movie;
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "hall_id", nullable = false)
    Hall hall;
}
