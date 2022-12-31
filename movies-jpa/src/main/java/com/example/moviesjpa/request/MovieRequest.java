package com.example.moviesjpa.request;

import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter
public class MovieRequest {
    private Long id;

    private String name;

    private String director;

    private int time;

    private String language;

    private int year;
}
