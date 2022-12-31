package com.example.moviesjpa.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NotFoundException extends RuntimeException{
    private String error;
    private Integer httpStatus;

    public NotFoundException(String error, Integer httpStatus) {
        super(error);
        this.httpStatus = httpStatus;
    }
}
