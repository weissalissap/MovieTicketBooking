package com.weissa.movieTicketBooking.entities;

import com.weissa.movieTicketBooking.constant.Constant;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Constant.THEATER_TABLE)
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    int theaterId;
    @Column(name = "name")
    String name;
    @Column(name = "number_of_halls")
    int numberOfHalls;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.MERGE)
    @JoinColumn(name = "city_id", nullable = false)
    City city;
}
