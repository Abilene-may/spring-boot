package com.example.moviesjpa.dto;

import com.example.moviesjpa.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieDTO {
    private List<Movie> movies;
    private Integer count;
}
