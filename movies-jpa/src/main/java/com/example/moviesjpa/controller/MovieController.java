package com.example.moviesjpa.controller;

import com.example.moviesjpa.dto.MovieDTO;
import com.example.moviesjpa.entity.Movie;
import com.example.moviesjpa.request.MovieRequest;
import com.example.moviesjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * @return danh sách movie trong repository
     */
    @GetMapping("/get-all-movie")
    public ResponseEntity<List<Movie>> getAllMovie(){
        return new ResponseEntity<>(movieService.getAllListMovie(), HttpStatus.OK);
    }

    /**
     * @param movieRequest
     * @return tìm movie theo id
     */
    @PostMapping("/search-by-id")
    public ResponseEntity<Movie> getMovieByID(@RequestBody MovieRequest movieRequest)
    {
        return new ResponseEntity<>(movieService.getMovieByiD(movieRequest.getId()), HttpStatus.OK);
    }

    /**
     * @param movieRequest
     * @return danh sách movie theo language
     */
    @PostMapping ("/search-by-language")
    public ResponseEntity<MovieDTO> getMovieByLanguage(@RequestBody MovieRequest movieRequest)
    {
        return new ResponseEntity<>(movieService.getMovieByLanguage(movieRequest.getLanguage()), HttpStatus.OK);
    }

    /**
     * @param movieRequest
     * @return movie vừa tạo
     */
    @PostMapping("/create-movie")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(movieService.createMovie(movieRequest), HttpStatus.OK);
    }

    /**
     * @param movieRequest
     * @return trả về movie đã update theo id tìm được
     */
    @PutMapping("/update-by-id")
    public ResponseEntity<Movie> updateMovieByID(@RequestBody MovieRequest movieRequest)
    {
        return new ResponseEntity<>(movieService.updateMovieByID(movieRequest), HttpStatus.OK);
    }

    /**
     * @param id
     * @return mess "Xóa thành công" hoặc báo lỗi "Không tìm thấy dữ liệu"
     */
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteMovieByID(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

}
