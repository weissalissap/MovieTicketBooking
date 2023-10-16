package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.entities.ShowSeat;
import com.weissa.movieTicketBooking.services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.SHOW_SEAT_CONTROLLER_REQUEST)
public class ShowSeatController {
    @Autowired
    private ShowSeatService showSeatService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody ShowSeat getShowSeatById(@PathVariable final Integer Id) {
        return showSeatService.getShowSeatById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<ShowSeat> getAllShowSeat() {
        return showSeatService.getAllShowSeat();
    }

    @PostMapping(value = "/add")
    public @ResponseBody ShowSeat addNewShowSeat(@RequestBody ShowSeat showSeat) {
        return showSeatService.save(showSeat);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteShowSeatById(@PathVariable final Integer Id) {
        showSeatService.delete(Id);
    }
}
