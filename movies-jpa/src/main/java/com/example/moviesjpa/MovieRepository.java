package com.example.moviesjpa.repository;

import com.example.moviesjpa.dto.MovieDTO;
import com.example.moviesjpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM movie m WHERE LOWER(m.movie_name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<Movie> findMovieByName(String name);

    List<Movie> findMovieByLanguage(String language);
}
