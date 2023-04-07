package com.example.moviesjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "movie")
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(generator = "movie_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "director")
    private String director;

    @Column(name = "time")
    private int time;

    @Column(name = "language")
    private String language;
    
    @Column(name = "year")
    private int year;
}
