package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.HallSeat;
import com.weissa.movieTicketBooking.services.HallSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.HALL_SEAT_CONTROLLER_REQUEST)
public class HallSeatController {
    @Autowired
    private HallSeatService hallSeatService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody HallSeat getHallSeatById(@PathVariable final Integer Id) {
        return hallSeatService.getHallSeatById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<HallSeat> getAllHallSeat() {
        return hallSeatService.getAllHallSeat();
    }

    @PostMapping(value = "/add")
    public @ResponseBody HallSeat addNewHallSeat(@RequestBody HallSeat hallSeat) {
        return hallSeatService.save(hallSeat);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteHallSeatById(@PathVariable final Integer Id) {
        hallSeatService.delete(Id);
    }
}
