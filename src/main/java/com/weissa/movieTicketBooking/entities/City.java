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
@Table(name = Constant.CITY_TABLE)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    int cityId;
    @Column(name = "name")
    String name;
    @Column(name = "country")
    String country;
}
