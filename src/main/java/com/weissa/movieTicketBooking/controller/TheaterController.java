package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Theater;
import com.weissa.movieTicketBooking.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.THEATER_CONTROLLER_REQUEST)
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody Theater getTheaterById(@PathVariable final Integer Id) {
        return theaterService.getTheaterById(Id);
    }

    @GetMapping(value = "/city/{City}", produces = {"application/json"})
    public @ResponseBody List<Theater> getTheaterByCity(@PathVariable final String City) {
        return theaterService.getAllTheaterByCity(City);
    }


    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @PostMapping(value = "/add")
    public @ResponseBody Theater addNewTheater(@RequestBody Theater theater) {
        return theaterService.save(theater);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteTheaterById(@PathVariable final Integer Id) {
        theaterService.delete(Id);
    }


}
