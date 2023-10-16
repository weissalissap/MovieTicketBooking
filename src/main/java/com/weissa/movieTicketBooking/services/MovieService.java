package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.City;
import com.weissa.movieTicketBooking.entities.Movie;
import com.weissa.movieTicketBooking.entities.Show;
import com.weissa.movieTicketBooking.models.ShowSeatsAvailable;
import com.weissa.movieTicketBooking.repositories.CityRepository;
import com.weissa.movieTicketBooking.repositories.MovieRepository;
import com.weissa.movieTicketBooking.repositories.ShowRepository;
import com.weissa.movieTicketBooking.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public void delete(int id) {
        Movie movie = movieRepository.findById(id);
        movieRepository.delete(movie);
    }

    public List<Show> getAllShowByCityByNameAndDate(String cityName, String showDate, String movieName){
        City city  = cityRepository.findByName(cityName).orElse(null);
        Movie movie =  movieRepository.findByMovieName(movieName);
        List<Show> showList = new ArrayList<>();
        if(city == null) return showList;
        return showRepository.findAllShowByDateAndByMovieNameAndByCity(city.getCityId(),showDate,movie.getMovieId());
    }

    public List<ShowSeatsAvailable> getAllShowByCityByNameAndDateWithAvlSeats(String cityName, String showDate, String movieName){
        City city  = cityRepository.findByName(cityName).orElse(null);
        Movie movie =  movieRepository.findByMovieName(movieName);
        List<ShowSeatsAvailable> showList = new ArrayList<>();
        if(city == null) return showList;
        return showSeatRepository.findAllShowByDateAndByMovieNameAndByCityBySeatAvl(city.getCityId(),showDate,movie.getMovieId());
    }

    public List<Show> getAllShowByDate(String showDate){
        return showRepository.findAllShowByDate(showDate);
    }

    public List<Show> getAllShowByDateAndByCity(String cityName, String showDate){
        City city  = cityRepository.findByName(cityName).orElse(null);
        List<Show> showList = new ArrayList<>();
        if(city == null) return showList;
        return showRepository.findAllShowByDateAndByCity(city.getCityId(), showDate);
    }

    public List<Show> getAllShowByMovie(String movieName){
        Movie movie =  movieRepository.findByMovieName(movieName);
        return showRepository.findAllShowByMovie(movie.getMovieId());
    }
}
