package com.weissa.movieTicketBooking.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatRequest {
    int userId;
    int showId;
    List<Integer> showSeatIdList;
}
