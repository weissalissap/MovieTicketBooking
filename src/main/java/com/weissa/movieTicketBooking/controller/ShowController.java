package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Movie;
import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.SHOW_CONTROLLER_REQUEST)
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody Show getShowById(@PathVariable final Integer Id) {
        return showService.getShowById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<Show> getAllShow() {
        return showService.getAllShow();
    }

    @PostMapping(value = "/add")
    public @ResponseBody Show addNewShow(@RequestBody Show show) {
        return showService.save(show);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteShowById(@PathVariable final Integer Id) {
        showService.delete(Id);
    }
}
