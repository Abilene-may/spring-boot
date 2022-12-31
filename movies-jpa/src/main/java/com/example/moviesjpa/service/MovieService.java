package com.example.moviesjpa.service;

import com.example.moviesjpa.entity.Movie;
import com.example.moviesjpa.request.MovieRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    List<Movie> getAllListMovie();
    Movie getMovieByiD(Long id);
    Movie createMovie(MovieRequest movieRequest);
    Movie updateMovieByID(MovieRequest movieRequest);
    void deleteMovie(Long id);
}
