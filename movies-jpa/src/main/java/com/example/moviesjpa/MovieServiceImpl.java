package com.example.moviesjpa.service;

import com.example.moviesjpa.dto.MovieDTO;
import com.example.moviesjpa.entity.Movie;
import com.example.moviesjpa.exception.NotFoundException;
import com.example.moviesjpa.repository.MovieRepository;
import com.example.moviesjpa.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllListMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieByiD(Long id) {
        Optional<Movie> movieByID = movieRepository.findById(id);
        if(movieByID.isEmpty()){
            throw new NotFoundException("Không tìm thấy dữ liệu movie id = " + id, 400);
        }
        return movieByID.get();
    }

    @Override
    public MovieDTO getMovieByLanguage(String language) {
        List<Movie> movie = movieRepository.findMovieByLanguage(language);
        if (movie.isEmpty()) {
            throw new NotFoundException("Không tìm thấy dữ liệu movie có language là " + language, 404);
        }
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovies(movie);
        movieDTO.setCount(movie.size());
        return movieDTO;
    }

    @Override
    public Movie createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setName(movieRequest.getName());
        movie.setDirector(movieRequest.getDirector());
        movie.setTime(movieRequest.getTime());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setYear(movieRequest.getYear());
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovieByID(MovieRequest movieRequest) {
        Optional<Movie> movieId = movieRepository.findById(movieRequest.getId());
        if(movieId.isEmpty()){
            throw new NotFoundException("Không tìm thấy id = " + movieRequest.getId(), 400);
        }
        Movie movie = movieId.get();
        movie.setName(movieRequest.getName());
        movie.setDirector(movieRequest.getDirector());
        movie.setTime(movieRequest.getTime());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setYear(movieRequest.getYear());
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<Movie> movieSearch = movieRepository.findById(id);
        if(movieSearch.isEmpty()){
            throw new NotFoundException("Không tìm thấy dữ liệu id = " + id, 400);
        }
        movieRepository.delete(movieSearch.get());
    }
}
