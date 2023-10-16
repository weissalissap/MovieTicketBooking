package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Hall;
import com.weissa.movieTicketBooking.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.HALL_CONTROLLER_REQUEST)
public class HallController {
    @Autowired
    private HallService hallService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody Hall getHallById(@PathVariable final Integer Id) {
        return hallService.getHallById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<Hall> getAllHall() {
        return hallService.getAllHall();
    }

    @PostMapping(value = "/add")
    public @ResponseBody Hall addNewHall(@RequestBody Hall hall) {
        return hallService.save(hall);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteHallById(@PathVariable final Integer Id) {
        hallService.delete(Id);
    }
}
