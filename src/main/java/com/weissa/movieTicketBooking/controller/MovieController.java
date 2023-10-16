package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.Movie;
import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.models.ShowSeatsAvailable;
import com.weissa.movieTicketBooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.MOVIE_CONTROLLER_REQUEST)
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody Movie getMovieById(@PathVariable final Integer Id) {
        return movieService.getMovieById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

    @PostMapping(value = "/add")
    public @ResponseBody Movie addNewMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteMovieById(@PathVariable final Integer Id) {
        movieService.delete(Id);
    }

    @GetMapping(value = "/city/{city}/date/{showDate}/name/{movieName}", produces =  {"application/json"})
    public @ResponseBody List<Show> getAllShowByMovieByDateByCity(@PathVariable final String city, @PathVariable final String showDate, @PathVariable final String movieName){
        return movieService.getAllShowByCityByNameAndDate(city, showDate, movieName);
    }

    @GetMapping(value = "/date/{showDate}", produces =  {"application/json"})
    public @ResponseBody List<Show> getAllShowByDate( @PathVariable final String showDate){
        return movieService.getAllShowByDate(showDate);
    }

    @GetMapping(value = "/city/{city}/date/{showDate}", produces =  {"application/json"})
    public @ResponseBody List<Show> getAllShowByDateByCity(@PathVariable final String city, @PathVariable final String showDate){
        return movieService.getAllShowByDateAndByCity(city, showDate);
    }

    @GetMapping(value = "/name/{movieName}", produces =  {"application/json"})
    public @ResponseBody List<Show> getAllShowByMovie(@PathVariable final String movieName){
        return movieService.getAllShowByMovie(movieName);
    }

    @GetMapping(value = "/city/{city}/date/{showDate}/name/{movieName}/available", produces =  {"application/json"})
    public @ResponseBody List<ShowSeatsAvailable> getAllShowByMovieByDateByCityWithAvlSeats(@PathVariable final String city, @PathVariable final String showDate, @PathVariable final String movieName){
        return movieService.getAllShowByCityByNameAndDateWithAvlSeats(city, showDate, movieName);
    }
}
