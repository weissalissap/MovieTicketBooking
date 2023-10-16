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
@Table(name = Constant.MOVIE_TABLE)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    int movieId;
    @Column(name = "name")
    String movieName;
    @Column(name = "language")
    String movieLanguage;
    @Column(name = "genre")
    String movieGenre;
    @Column(name = "description")
    String description;
}
