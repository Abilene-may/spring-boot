package com.example.moviesjpa.service;

import com.example.moviesjpa.dto.MovieDTO;
import com.example.moviesjpa.entity.Movie;
import com.example.moviesjpa.request.MovieRequest;

import java.util.List;

public interface MovieService {
    List<Movie> getAllListMovie();
    Movie getMovieByiD(Long id);
    MovieDTO getMovieByLanguage(String language);
    Movie createMovie(MovieRequest movieRequest);
    Movie updateMovieByID(MovieRequest movieRequest);
    void deleteMovie(Long id);
}
